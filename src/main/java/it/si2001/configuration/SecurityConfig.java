package it.si2001.configuration;


/*
Classe di configurazione dello spring security della nostra applicazione
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private UserDetailsService userDetailsService;
    private PersistentTokenRepository tokenRepository;

    @Autowired
    public SecurityConfig(@Qualifier("customUserDetailsService") UserDetailsService userDetailsService,@Qualifier("persistenteTokenRepository") PersistentTokenRepository tokenRepository) {
        this.userDetailsService=userDetailsService;
        this.tokenRepository=tokenRepository; }

    // attivazione della criptazione delle password
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }


    // configurazione dei dettagli utenti

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(this.userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider; }


        /*
        configurazione degli accessi alle pagine in base ai ruoli utenti
         */

        private static final String[] USER_MATCHER =
                {
                        "/",
                        "/edit/**",
                        "/delete/**"
                };
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(USER_MATCHER).access("hasRole('user')")
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .rememberMe().rememberMeParameter("ricordami").tokenRepository(tokenRepository)
                .tokenValiditySeconds(86400).and().exceptionHandling().accessDeniedPage("/Access_Denied");
        }



    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices()
    {
        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
                "ricordami", userDetailsService, tokenRepository);

        return tokenBasedservice;}


    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver()
    {
        return new AuthenticationTrustResolverImpl();
    }

}
