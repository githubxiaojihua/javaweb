package xiaojihua.aspacj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import xiaojihua.annotation.NeedTest;
import xiaojihua.domain.Person;

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


    //=============测试增强函数的参数绑定
    @Before("execution(* xiaojihua.domain.Person.testArgs(..)) && args(name,num,..)")
    public void testArgs(int num, String name){
        System.out.println("in before advice====================");
        System.out.println("name:" + name);
        System.out.println("num:" + num);
    }

    /*@After("@annotation(anno)")
    public void testArgs(NeedTest anno){
        System.out.println("in after advice====================");
        System.out.println(anno.value());
    }*/

    @Before(value="target(bean) && @annotation(anno)",argNames="anno,bean")
    public void testArgNames(NeedTest anno,Person bean){
        System.out.println("in testArgNames advice====================");
        System.out.println(bean);
        System.out.println(anno.value());
    }

}
