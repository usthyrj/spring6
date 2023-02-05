package ltd.regis.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  12:04
 * @Description:
 * @Version: 1.0
 */

public class TimerAspect {

    //通知
    public void arounbdAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();
        joinPoint.proceed();
        int i = 100000000;
        while (i-- > 0);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");


    }

}
