package ltd.regis.spring6.config;

import com.alibaba.druid.pool.DruidDataSource;
import jakarta.annotation.Resource;
import ltd.regis.spring6.bean.MyDataSource;
import ltd.regis.spring6.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ltd.regis.spring6.bean")
@PropertySource("classpath:/jdbc.properties")
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;



    @Bean(name = "user")
    public User getUser() {
        return new User();
    }

    @Bean(name = "druidDatasource")
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName(driver);
        dds.setUrl(url);
        dds.setUsername(username);
        dds.setPassword(password);

        return dds;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Autowired @Qualifier("druidDatasource")DataSource druidDatasource) {
        System.out.println(druidDatasource);
        return new JdbcTemplate(druidDatasource);
    }
}
