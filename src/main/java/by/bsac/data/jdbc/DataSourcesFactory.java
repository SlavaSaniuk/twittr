package by.bsac.data.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 */
@Configuration
@PropertySource("classpath:properties/database.properties")
public class DataSourcesFactory {

    @Value("${DB.URL}")
    private String db_url; //Database URL

    @Value("${DB.DRIVER}")
    private String db_driverClass; //Database driver class (default: MySQL)

    @Value("${DB.USERNAME}")
    private String db_username; //Database administrator login

    @Value("${DB.PASSWORD}")
    private String db_password; //Database administrator password

    @Profile("development")
    @Bean("data_source")
    @Description("DataSource for development.")
    public DriverManagerDataSource devDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(db_url);
        ds.setDriverClassName(db_driverClass);
        ds.setUsername(db_username);
        ds.setPassword(db_password);
        return ds;
    }

    @Profile("production")
    @Bean("data_source")
    @Description("DataSource for production.")
    public DataSource prodDataSource() throws NamingException {

        Context ctx = new InitialContext();
        Context envCtx = (Context) ctx.lookup("java:comp/env");
        return (DataSource) envCtx.lookup("jdbc/twittr");

    }


}
