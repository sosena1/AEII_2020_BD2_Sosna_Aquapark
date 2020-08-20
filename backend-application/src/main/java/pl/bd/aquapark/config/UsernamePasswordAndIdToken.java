package pl.bd.aquapark.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsernamePasswordAndIdToken extends UsernamePasswordAuthenticationToken {

    private long userId;

    public UsernamePasswordAndIdToken(Object principal, Object credentials, int userId, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UsernamePasswordAndIdToken that = (UsernamePasswordAndIdToken) o;

        return userId == that.userId;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }
}
