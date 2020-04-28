package pl.bd.aquapark;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    USER("USER"),
    ANALITIC("ANALITIC"),
    SELLER("SELLER");


    private final String role;

    private Roles(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return this.role;
    }

    public String toString() {
        return this.role;
    }
}
