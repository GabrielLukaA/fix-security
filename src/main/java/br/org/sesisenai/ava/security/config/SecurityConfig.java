//package br.org.sesisenai.ava.security.config;
//
//import br.org.sesisenai.ava.security.filter.FilterAuthentication;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.context.SecurityContextRepository;
//
//@Configuration
//@AllArgsConstructor
//public class SecurityConfig {
//
//
//    private final SecurityContextRepository repo;
//    private final FilterAuthentication filterAuthentication;
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//        httpSecurity.formLogin(AbstractHttpConfigurer::disable);
//        httpSecurity.logout(AbstractHttpConfigurer::disable);
//        httpSecurity.authorizeHttpRequests(authorizeHttpRequests -> {
//            authorizeHttpRequests
//                    .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
//                    .requestMatchers(HttpMethod.POST, "/api/instrutor").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/api/cursos").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/api/cursos/**").permitAll()
//                    .anyRequest().hasAnyAuthority();
//        });
//
//        httpSecurity.formLogin(AbstractHttpConfigurer::disable);
//        httpSecurity.logout(AbstractHttpConfigurer::disable);
//        httpSecurity.sessionManagement(config -> {
//            config.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        });
//
////        httpSecurity.addFilterBefore(filterAuthentication, UsernamePasswordAuthenticationFilter.class);
//
//        return httpSecurity.build();
//    }
//
//
//}