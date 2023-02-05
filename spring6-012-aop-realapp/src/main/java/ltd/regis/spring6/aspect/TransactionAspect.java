package ltd.regis.spring6.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.aspect
 * @Author: Regis
 * @CreateTime: 2023-02-04  16:35
 * @Description:
 * @Version: 1.0
 */

@Aspect
@Component
public class TransactionAspect {

    @Pointcut("execution(* ltd.regis.spring6.service..*(..))")
    public void normalPointCut(){}

    //编程式事务解决方案
    @Around("normalPointCut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        try {
            //前环绕
            System.out.println("开启事务");
            joinPoint.proceed();
            //后环绕
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
        }
    }

}
