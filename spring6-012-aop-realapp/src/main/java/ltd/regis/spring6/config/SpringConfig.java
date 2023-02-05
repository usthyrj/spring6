package ltd.regis.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.config
 * @Author: Regis
 * @CreateTime: 2023-02-04  16:28
 * @Description:
 * @Version: 1.0
 */

@Configuration
@ComponentScan({"ltd.regis.spring6.service", "ltd.regis.spring6.aspect", "ltd.regis.spring6.biz"})
@EnableAspectJAutoProxy
public class SpringConfig {

}
