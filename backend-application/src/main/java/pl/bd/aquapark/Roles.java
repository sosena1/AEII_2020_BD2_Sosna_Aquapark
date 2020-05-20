package pl.bd.aquapark;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    CLIENT("Client"),
    ANONYMOUS_CLIENT("AnonymousClient"),
    GATE("Gate"),
    ANALYST("Analyst"),
    MAINTAINER("Cleaner"),
    PRICELIST_MAINTAINER("PriceChanger"),
    CASHIER("Cashier");


    private final String role;

    private Roles(String role) {
        this.role = role;
    }

    @Deprecated //use toString instead
    public String getAuthority() {
        return toString();
    }

    public String toString() {
        return "ROLE_" + this.role; //"ROLE_" must be present, because for some reason Spring really likes it
    }
}
