package ltd.regis.spring6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.aspect
 * @Author: Regis
 * @CreateTime: 2023-02-04  17:11
 * @Description:
 * @Version: 1.0
 */
@Component
@Aspect
public class SecurityAspect {

    @Pointcut("execution(* ltd.regis.spring6.biz..save*(..))")
    public void savePointCut() {}

    @Pointcut("execution(* ltd.regis.spring6.biz..update*(..))")
    public void updatePointCut() {}

    @Pointcut("execution(* ltd.regis.spring6.biz..delete*(..))")
    public void deletePointCut() {}

    @Before("savePointCut() || updatePointCut() || deletePointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(new Date());
        //输出日志信息
        System.out.println(nowTime + "张三访问了" + joinPoint.getSignature().toString().split(" ")[1]+ "方法");

    }
}
