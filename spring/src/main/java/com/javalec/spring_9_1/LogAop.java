package com.javalec.spring_9_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class LogAop {
    public Object loggerAop(ProceedingJoinPoint joinPoint){
        String signatureStr = joinPoint.getSignature().toShortString();
        System.out.println(signatureStr + " is start.");
        long st = System.currentTimeMillis();
        Object obj = null;

        try{
            obj = joinPoint.proceed();
        } catch (Throwable e){
            e.printStackTrace();
        } finally {
            long et = System.currentTimeMillis();
            System.out.println(signatureStr+ " is finished");
            System.out.println(signatureStr+ "경과시간 : "+(et - st));
        }

        return obj;
    }
}
