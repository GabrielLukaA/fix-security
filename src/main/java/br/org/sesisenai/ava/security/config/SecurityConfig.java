package br.org.sesisenai.ava.security.config;

//import br.org.sesisenai.ava.security.filter.FilterAuthentication;

import br.org.sesisenai.ava.security.acessses.IsLoggedUser;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@AllArgsConstructor
public class SecurityConfig {


    private final SecurityContextRepository repo;
    //    private final FilterAuthentication filterAuthentication;
    private final IsLoggedUser isLoggedUser;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//        httpSecurity.formLogin(AbstractHttpConfigurer::disable);
        httpSecurity.logout(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(authorizeHttpRequests -> {
            authorizeHttpRequests

                    .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/instrutor").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/cursos").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/cursos/{id}").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/api/usuarios/{id}").access(isLoggedUser)
                    .requestMatchers(HttpMethod.GET, "/api/usuarios/{id}").access(isLoggedUser)
                    .requestMatchers(HttpMethod.DELETE, "/api/usuarios/{id}").access(isLoggedUser)
                    .requestMatchers(HttpMethod.PATCH, "/api/usuarios/{id}").access(isLoggedUser)
//                    .requestMatchers(HttpMethod.GET, "/api/cursos/{cursoId}/aulas").access()
//                    .requestMatchers(HttpMethod.GET, "/api/cursos/{cursoId}/aulas/{aulaId}").access()
//                    .requestMatchers(HttpMethod.POST, "/api/cursos/{cursoId}/incricoes").access()
//                    .requestMatchers(HttpMethod.POST, "/api/cursos/{cursoId}/incricoes/cancelar").access()
                    .requestMatchers(HttpMethod.POST, "/api/cursos").access()
                    .requestMatchers(HttpMethod.DELETE, "/api/cursos/{id}").access()
                    .requestMatchers(HttpMethod.PUT, "/api/cursos/{id}").access()
                    .requestMatchers(HttpMethod.GET, "/api/usuarios").hasAnyAuthority("INSTRUTOR", "ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/usuarios/{id}").hasAnyAuthority("INSTRUTOR", "ADMIN")
                    //anyrequest, é pra qualquer requisição, além das citadas
                    .anyRequest().authenticated();


        });

        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.logout(AbstractHttpConfigurer::disable);
        httpSecurity.sessionManagement(config -> {
            config.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        httpSecurity.securityContext(httpSecuritySecurityContextConfigurer -> httpSecuritySecurityContextConfigurer.securityContextRepository(repo));

//        httpSecurity.addFilterBefore(filterAuthentication, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }


}