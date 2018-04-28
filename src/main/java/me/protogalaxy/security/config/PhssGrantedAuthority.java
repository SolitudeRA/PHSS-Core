package me.protogalaxy.security.config;

import org.springframework.security.core.GrantedAuthority;

//TODO: Role check method
public class PhssGrantedAuthority implements GrantedAuthority {
    private static final String USER_AUTHORITY = "ROLE_USER";
    private static final String ADMIN_AUTHORITY = "ROLE_ADMIN";
    private static final String GUEST_AUTHORITY = "ROLE_GUEST";
    private final String role;

    public PhssGrantedAuthority(String role) {
        if (!(role.contains(ADMIN_AUTHORITY) || role.contains(USER_AUTHORITY) || role.contains(GUEST_AUTHORITY))) {
            throw new IllegalArgumentException("role set illegal");
        }
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return this.role;
    }

    @Override
    public int hashCode() {
        return this.role.hashCode();
    }
}
