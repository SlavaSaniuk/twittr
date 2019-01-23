package by.bsac.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


/**
 *
 */
@Configuration
@Import(ThymeleafConfiguration.class)
@EnableWebMvc
@ComponentScan(basePackages = "by.bsac.controllers.navigation")
public class WebConfiguration implements WebMvcConfigurer {

    /* Thymeleaf configuration class */
    @Autowired
    private ThymeleafConfiguration thymeleafConfiguration;


    /**
     * Thymeleaf view resolver.
     * @return - view resolver.
     */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(thymeleafConfiguration.templateEngine());
        return  viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
