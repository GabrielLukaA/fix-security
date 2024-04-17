package br.org.sesisenai.ava.security.config;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@AllArgsConstructor
public class DatabaseConfig {

    private final UsuarioRepository userRepository;

    @PostConstruct
    public void init() {
        Usuario user = new Usuario();
//        Collection<Authorization> authorizations = new ArrayList<>();
//        authorizations.add(Authorization.GET);
        user.setEmail("teste123");
        user.setSenha(new BCryptPasswordEncoder().encode("luka123"));
//        user.setUsuarioDetailsEntity(UsuarioDetailsEntity.builder()
//                .user(user).enabled(true)
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .username("teste")
//                .password( new BCryptPasswordEncoder().encode("teste123"))
//                        .authorities(List.of(Authorization.GET, Authorization.POST, Authorization.POSTUSER))
//                .build());

        userRepository.save(user);
    }

}
