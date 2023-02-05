package ltd.regis.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  10:26
 * @Description:
 * @Version: 1.0
 */
@Component
@Aspect//切面类要用@Aspect标注
@Order(2)
public class LogAspect {    //切面

    /**
     * //切面 = 通知 + 切点
     * //通知就是增强代码，这里以方法的形式呈现
     * 前置通知是Before,
     * 后置通知是AfterReturning
     * 环绕通知Around
     * 最终通知After
     * 异常通知AfterThrowing
     */

    //定义通用切点
    @Pointcut("execution(* ltd.regis.spring6.service..*(..))")
    public void normalExecution() {
         //这个方法只是标记，方法名随意，方法体也无需任何代码
    }

    @Before("normalExecution()")
//    @Before("execution(* *(..)")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("This is a beforeAdvice.");
        //joinPoint方法在spring调用这个方法时自动传进来，我们可以直接使用
        System.out.println(joinPoint.getSignature().getName());
    }

    @AfterReturning("normalExecution()")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("This is a 后置通知");
    }

    @Around("normalExecution()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("This is a 前环绕通知");
        joinPoint.proceed();
        System.out.println("This is a 后环绕通知");
    }

    @AfterThrowing("normalExecution()")
    public void afterThrowingAdvice() {
        System.out.println("THis is a 异常通知");
    }

    @After("normalExecution()")
    public void afterAdvice() {
        System.out.println("This is a 最终通知");
    }


}
