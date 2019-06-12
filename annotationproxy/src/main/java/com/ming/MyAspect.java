package com.ming;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    /**
     * 对真实对象的引用
     */
    private Object targetObject = null;

    public MyAspect(Object obj){
        this.targetObject = obj;
    }
    /**
     * 该方法是一个标识,标识一个范围
     */
    @Pointcut("execution(* * add(..))")
    public void allMethod(){}

    //横切关注点 Advice
    @Before("allMethod")
    public void SecurityCheck(){
        System.out.println("********SecurityCheck()******");
    }
}
