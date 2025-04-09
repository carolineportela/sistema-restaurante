package br.senai.sp.menu.restaurante.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * Expõe o AuthenticationManager como um bean para uso em outras partes do sistema,
     * como o LoginUseCase.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Configura as regras de segurança da aplicação.
     * Aqui deixamos tudo permitido temporariamente — depois vamos proteger os endpoints com JWT.
     */
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // desativa CSRF para facilitar testes com Postman, etc.
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        // permite todas as requisições (por enquanto)
//                        .anyRequest().permitAll()
//                );
//
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/users/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/v1/users/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
    //esse é o certo que usa a senha criptografada
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }


     //esse é pra conseguir testar com a senha sem criptografia
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return NoOpPasswordEncoder.getInstance();
//        }

}
