package ltd.regis.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  11:39
 * @Description: 安全切面
 * @Version: 1.0
 */
@Component
@Aspect
@Order(3)
public class SecurityAspect {

    @Before("ltd.regis.spring6.service.LogAspect.normalExecution()")
    public void beforeAdvice() {
        System.out.println("前置通知：安全...");
    }
}
