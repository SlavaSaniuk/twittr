package by.bsac.data.jdbc;

import by.bsac.data.UserDaoImpl;
import by.bsac.data.dao.UserDao;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 *
 */
@Configuration
@PropertySource("classpath:properties/database.properties")
@ComponentScan(basePackages = "by.bsac.data")
@Import(by.bsac.data.jdbc.DataSourcesFactory.class)
public class DatabaseConfiguration {

    @Bean("user_dao")
    @Description("User DAO Implementation")
    @Resource(name = "data_source")
    public UserDao getUserDao(DataSource ds) {
        return new UserDaoImpl(ds);
    }



}
