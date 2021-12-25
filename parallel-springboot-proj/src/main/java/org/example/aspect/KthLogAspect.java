package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.annotation.KthLog;
import org.example.entity.User;
import org.springframework.stereotype.Component;
//https://blog.csdn.net/qq_37435078/article/details/90523309
@Aspect
@Component
public class KthLogAspect {
    @Pointcut("@annotation(org.example.annotation.KthLog)")
    private void pointcut() { }

//    @Before("pointcut() && @annotation(logger)")
//    public void advice(JoinPoint joinPoint, KthLog logger) {
//        //System.out.println("---Kth日志内容为【" + logger.value() + "】--");
//        System.out.println("["
//                + joinPoint.getSignature().getDeclaringType().getSimpleName()
//                + "][" + joinPoint.getSignature().getName()
//                + "]-日志内容-[" + logger.value() + "]");
//    }

    @Around("pointcut() && @annotation(logger)")
    public Object advice(ProceedingJoinPoint joinPoint, KthLog logger) {
        System.out.println("["
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                + "][" + joinPoint.getSignature().getName()
                + "]-日志内容-[" + logger.value() + "]");

        Object result = null;

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if(args[i] instanceof Integer) {
                args[i] = (Integer)args[i] - 1;
                break;
            }
        }

        try {
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }
}
