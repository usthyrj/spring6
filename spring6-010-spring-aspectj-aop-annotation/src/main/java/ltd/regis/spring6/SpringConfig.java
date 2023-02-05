package ltd.regis.spring6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis
 * @Author: Regis
 * @CreateTime: 2023-02-04  10:19
 * @Description:
 * @Version: 1.0
 */
@Configuration
@ComponentScan({"ltd.regis.spring6"})
@EnableAspectJAutoProxy(proxyTargetClass = true)//开启AspectJ自动代理,如果proxyTargetClass = true则表示必须使用cglib代理，默认false为jdk+cglib
public class SpringConfig {

}
