package pl.bd.aquapark;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    //TODO check correctness with database
    USER("USER"),
    GATE("GATE"),
    ANALYTIC("ANALYTIC"),
    MAINTAINER("MAINTAINER"),
    SELLER("SELLER");


    private final String role;

    private Roles(String role) {
        this.role = role;
    }

    @Deprecated //uzywajcie toString
    public String getAuthority() {
        return this.role;
    }

    public String toString() {
        return this.role;
    }
}
