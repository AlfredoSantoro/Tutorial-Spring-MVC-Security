package it.si2001.configuration;




/*
Al bootstrap del servlet container, verrà istanziata questa classe e verrà eseguito il metodo startUp
in cui indichiamo a spring il dispatcher servlet ovvero il front controller e gli indichiamo la classe
di configurazione di spring
 */


// utilizziamo questa implementazione perchè è più coincisa. Viene definito il file di configurazione
// e viene definito il SelvetMapping del front controller il quale indica che gestirà ogni richiesta.


/*
NB. la configurazione basata sulle annotazioni java, dipende dal servlet container 3.0. Quindi dobbiamo assicurarci
di non avere nessun file xml
 */

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ HelloWorldConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }}
