package it.si2001.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


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
@Import(JpaConfiguration.class)
@ComponentScan(basePackages = "it.si2001")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer; }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver); }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/"); }
}
