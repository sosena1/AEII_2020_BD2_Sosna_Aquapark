package pl.bd.aquapark.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        //todo
        return new UsernamePasswordAndIdToken(name, password, 0, new ArrayList<>());

        /*
        if (authenticationService.lazyAuthenticate(name, password)) {
            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        }
        throw new BadCredentialsException("Authentication failed");*/
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
