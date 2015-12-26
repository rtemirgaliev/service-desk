package com.sd.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Utility class for Spring Security.
 */
public class SecurityUtils {

    private SecurityUtils() {
    }



    /**
     * Return the current user, or throws an exception, if the user is not
     * authenticated yet.
     *
     * @return the current user
     */
    public static User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null ) {
            if (authentication.getPrincipal() instanceof User) {
                return (User) authentication.getPrincipal();
            }
        }
        throw new IllegalStateException("User not found!!!");
    }
}
