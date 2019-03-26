package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"service"})
@ComponentScan(basePackages = "aop")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@MapperScan(basePackages = {"mapper"})
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        Properties prop = new Properties();
        try {
            prop.load(new ClassPathResource("log4j.properties").getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(prop.getProperty("DriverClassName"));
        hikariConfig.setJdbcUrl(prop.getProperty("JdbcUrl"));
        hikariConfig.setUsername(prop.getProperty("Username"));
        hikariConfig.setPassword(prop.getProperty("Password"));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        try {
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public DataSourceTransactionManager txManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
