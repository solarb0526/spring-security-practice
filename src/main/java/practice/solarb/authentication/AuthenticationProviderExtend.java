package practice.solarb.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import java.util.List;

public class AuthenticationProviderExtend implements AuthenticationProvider  {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String password = (String) authentication.getCredentials();
        UsernamePasswordAuthenticationToken authenticationToken = createAuthentication(id, password);
        authenticationToken.setDetails(authentication.getDetails());
        return authenticationToken;
    }

    public static UsernamePasswordAuthenticationToken createAuthentication(String id, String password) {
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ADMIN", "USER");
        User user = new User(id, password, authorities);
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
