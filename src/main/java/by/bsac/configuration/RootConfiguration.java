package by.bsac.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 */
@Configuration
@Import({by.bsac.data.jdbc.DatabaseConfiguration.class,
        by.bsac.services.ServicesConfiguration.class})
public class RootConfiguration {

}
