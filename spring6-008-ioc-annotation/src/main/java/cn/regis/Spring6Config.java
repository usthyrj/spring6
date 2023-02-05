package cn.regis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"cn.regis.dao", "cn.regis.service"})
public class Spring6Config {

}
