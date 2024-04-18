package br.org.sesisenai.ava.security.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public enum Authorization implements GrantedAuthority {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),

    ADMIN("ADMIN"),
     GETUSER("GETUSER"),
    INSTRUTOR("INSTRUTOR");


    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }
}
