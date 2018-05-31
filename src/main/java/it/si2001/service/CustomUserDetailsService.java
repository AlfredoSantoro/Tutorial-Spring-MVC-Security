package it.si2001.service;


import it.si2001.model.Role;
import it.si2001.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import sun.plugin.util.UserProfile;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
questa classe è utilizzata per poter caricare i dati di un utente
 */



/*
Questa classe riceverà una stringa la quale rappresenta la username nel momento in cui l'utente
sta tentando di accedere al sito.
Avendo questa stringa,effettuiamo una ricerca per vedere se realmente questo utente è nel nostro db.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    private UserService userService;
    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    public CustomUserDetailsService(UserService userService){this.userService=userService;}

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = this.userService.findByUsername(s);

        if(user == null){
            throw new UsernameNotFoundException(" User not found ");
        }

        /*
        utilizzato per autenticare il nostro utente
         */
        UserBuilder userBuilder = null;
        // settiamo la username
        userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        userBuilder.disabled(true);
        userBuilder.password(user.getPassword());
        userBuilder.authorities(getGrantedAuthorities(user));
        return userBuilder.build();
    }


    /*
    get di tutti i ruoli dell'utente che sta cercando di accedere
     */
    private List<GrantedAuthority> getGrantedAuthorities(User user)
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Role role : user.getRoles())
        {
            logger.info("UserProfile : {}", role);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }
}
