package by.bsac.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 */
@Configuration
@Import(by.bsac.data.jdbc.DatabaseConfiguration.class)
@ComponentScan(basePackages = {"by.bsac.services", "by.bsac.models"})
public class RootConfiguration {



}
