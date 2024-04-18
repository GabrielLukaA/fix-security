package br.org.sesisenai.ava.security.controller;

import br.org.sesisenai.ava.entity.Usuario;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<String> authenticate(Usuario usuario,  HttpServletRequest request, HttpServletResponse response) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getUserDetailsEntity().getUsername(), usuario.getUserDetailsEntity().getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
    return ResponseEntity.ok("User authenticated");
    }
}


