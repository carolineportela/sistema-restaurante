package br.senai.sp.menu.restaurante.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import br.senai.sp.menu.restaurante.security.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Recupera o header Authorization
        String authorizationHeader = request.getHeader("Authorization");

        // Verifica se o header contém o prefixo "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Extrai o token JWT do header
            // Remover "Bearer " (7 caracteres)
            String token = authorizationHeader.substring(7);

            try {
                // Valida o token e obtém o nome de usuário
                String username = jwtService.getUsernameFromToken(token);

                // Se o token for válido, cria um objeto de autenticação e coloca no contexto de segurança
                if (username != null) {
                    var authentication = new UsernamePasswordAuthenticationToken(username, null, null);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                // Lida com erro de validação do token, pode ser logado ou retornado como erro
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Ou faça alguma outra tratativa
            }
        }

        // Continua a cadeia de filtros
        filterChain.doFilter(request, response);
    }
}