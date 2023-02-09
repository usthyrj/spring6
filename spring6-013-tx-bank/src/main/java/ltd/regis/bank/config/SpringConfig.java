package ltd.regis.bank.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.config
 * @Author: Regis
 * @CreateTime: 2023-02-05  08:15
 * @Description:
 * @Version: 1.0
 */
@Configuration
@ComponentScan({"ltd.regis.bank"})
@EnableTransactionManagement
@PropertySource({"classpath:/jdbc.properties"})
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url}")
    private String url;



    @Bean("druidSource")
    public DataSource getDataSource(){
        DruidDataSource druid = new DruidDataSource();
        druid.setDriverClassName(driver);
        druid.setUrl(url);
        druid.setUsername(username);
        druid.setPassword(password);
        return druid;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource druidSource) {
//        System.out.println(druidSource);
        return new JdbcTemplate(druidSource);
    }

    //事务管理器
    @Bean("txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
        return txManager;
    }

}
