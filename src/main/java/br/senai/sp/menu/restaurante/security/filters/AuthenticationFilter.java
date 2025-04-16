package br.senai.sp.menu.restaurante.security.filters;

import br.senai.sp.menu.restaurante.errors.exceptions.UnauthorizedException;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
import br.senai.sp.menu.restaurante.security.service.JwtTokenService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final UsersRepository usersRepository;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            final var token = this.extractToken(request);

            if (Objects.isNull(token)) {
                filterChain.doFilter(request, response);
                return;
            }

            this.authenticate(jwtTokenService.getUserId(token), request);
            filterChain.doFilter(request, response);
        } catch (UnauthorizedException e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token inválido ou expirado.");
        }
    }

    private String extractToken(HttpServletRequest request) {
        final var token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7);
    }

    private void authenticate(UUID userId, HttpServletRequest request) {
        final var user = usersRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        final var userDetails = new UsersDetailsDTO(user);

        final var authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
