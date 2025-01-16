package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class PostgresDataSource {

    @Bean
    public DataSource dataSource(Environment env) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername(env.getProperty("postgres.dbUser"));
        ds.setPassword(env.getProperty("postgres.dbPassword"));
        ds.setUrl(env.getProperty("postgres.dbUrl"));
        return ds;
    }

    @Bean("dialect")
    public String dialect() {
        return "org.hibernate.dialect.PostgreSQLDialect";
    }

}