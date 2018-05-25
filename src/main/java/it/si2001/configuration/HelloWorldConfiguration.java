package it.si2001.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
* i bean e le dipendenze che hanno, sono riflesse nelle configurazioni le quali sono
* utilizzate dal container IoC di spring
* Spring ottiene le informazioni su come istanziare e configurare gli oggetti attraverso
* file di configurazione
*
* @EnableWebMvc invece dà supporto ai controller nell'utilizzare @RequestMapping
* @ComponentScan invece indica a spring dove cercare le classi da scannerizzare e gestire nel container
* in funzione di un basePackages
* */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.si2001")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {


    /*stiamo definendo un bean il quale sarà gestito dal container di spring. Il compito di questo benan è
     quello di definire un risolutore di view il quale definisce come le viste indicate dai controller
     devono essere definite. Nel nostro caso sono delle JSTL con estensione jsp. */

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}
