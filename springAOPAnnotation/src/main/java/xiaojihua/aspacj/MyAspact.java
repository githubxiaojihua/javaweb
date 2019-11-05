package xiaojihua.aspacj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义一个切面类
 * 有增强方法
 *
 * 需要在配置文件中进行配置
 */
@Component("myAspect")
@Aspect
public class MyAspact {

    /**
     * 前置增强
     */
    @Before("execution(* xiaojihua.domain.Person.save(..))")
    public void beforeMethod(){
        System.out.println("----beforeMethod-----");
    }

    /**
     * 后置增强
     */
    @AfterReturning("execution(* xiaojihua.domain.Person.delete(..))")
    public void afterRunningMethod(){
        System.out.println("-----afterRunningMethod-----");
    }

    /**
     * 环绕增强
     */
    @Around("execution(* xiaojihua.domain.Person.find(..))")
    public void aroundMethod(ProceedingJoinPoint pdp) throws Throwable {
        System.out.println("方法之前执行");
        // 原有方法执行一下
        pdp.proceed();// method.invoke();
        System.out.println("方法之后执行");
    }

    /**
     * 异常增强
     */
    @AfterThrowing("execution(* xiaojihua.domain.Person.update(..))")
    public void throwingMethod(){
        System.out.println("---throwingMethod----");
    }

    /**
     * finally增强
     */
    @After("execution(* xiaojihua.domain.Person.update(..))")
    public void afterMethod(){
        System.out.println("--不管你有没有异常,我都出来了---");
    }
}
