package it.si2001.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/*
Tramite questa classe otteniamo la user dell'utente che è loggato
 */

@Component
public class SpringSecurityContext {

    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();


    public String getCurrentUser(){
        if( authentication == null )
            return null;
        return authentication.getName();
    }
}
