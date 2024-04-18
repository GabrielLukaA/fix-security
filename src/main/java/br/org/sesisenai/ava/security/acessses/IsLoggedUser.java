package br.org.sesisenai.ava.security.acessses;

import br.org.sesisenai.ava.security.model.Authorization;
import br.org.sesisenai.ava.security.model.UserDetailsEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@AllArgsConstructor

public class IsLoggedUser implements AuthorizationManager<RequestAuthorizationContext> {
    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {

        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        UserDetailsEntity userDetailsEntity = (UserDetailsEntity) authentication.get().getPrincipal();
        if (userDetailsEntity.getUser().getId() == Long.parseLong(object.getVariables().get("id"))
        ) {
            return new AuthorizationDecision(true);
        } else if (userDetailsEntity.getAuthorities().contains(Authorization.ADMIN)){
            return new AuthorizationDecision(true);
        }


        return new AuthorizationDecision(false);
    }
}
