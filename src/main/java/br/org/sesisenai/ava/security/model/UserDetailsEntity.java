package br.org.sesisenai.ava.security.model;


import br.org.sesisenai.ava.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class UserDetailsEntity  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String password;
   private String username;
   private Collection<Authorization> authorities = null;
   private boolean accountNonExpired = true;
   private boolean accountNonLocked = true;
   private boolean credentialsNonExpired = true;
   private boolean enabled = true;
    @OneToOne(mappedBy = "userDetailsEntity")
    @JsonIgnore
    private Usuario user;

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
