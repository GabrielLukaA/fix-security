package br.org.sesisenai.ava.security.config;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import br.org.sesisenai.ava.security.model.Authorization;
import br.org.sesisenai.ava.security.model.UserDetailsEntity;
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
        userRepository.findUsuarioByUserDetailsEntity_Username("luka");
        if (!userRepository.findUsuarioByUserDetailsEntity_Username("luka").isPresent()) {

            Usuario user = new Usuario();
//        Collection<Authorization> authorizations = new ArrayList<>();
//        authorizations.add(Authorization.GET);
            user.setUserDetailsEntity(UserDetailsEntity.builder()
                    .user(user).enabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .username("luka")
                    .password(new BCryptPasswordEncoder().encode("luka123"))
                    .authorities(List.of(Authorization.ADMIN))
                    .build());

            userRepository.save(user);

        }

    }

}
