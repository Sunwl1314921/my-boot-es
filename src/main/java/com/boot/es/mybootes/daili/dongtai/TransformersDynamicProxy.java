package com.boot.es.mybootes.daili.dongtai;

import org.apache.commons.math3.exception.MathInternalError;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransformersDynamicProxy implements InvocationHandler {

    private Object proxyObject;

    public TransformersDynamicProxy(Object trans){
        this.proxyObject=trans;
    }

    /**
     * 获取代理对象
     */
    public Object newProxyInstance(){
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(),
                                      proxyObject.getClass().getInterfaces(),
                                   this);
    }

    /**
     * 说明：实现InvocationHandler接口后实现invoke接口，这个接口中就定义了这一个接口，源码：
     * public interface InvocationHandler {
     *      public Object invoke(Object proxy, Method method, Object[] args)
     *          throws Throwable;
     *      }
     *}
     * proxy：指我们所代理的真实对象
     * method：指的是我们所要调用真实对象的某个方法Method对象
     * args：指调用真实对象某个方法时接收的参数
     * 在newProxyInstance方法内，通过Proxy类生成代理对象，第二个参数Interfaces，是获取当前目标类实现的所有接口。
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始动态代理");
        method.invoke(proxyObject,args);//执行目标方法
        System.out.println("动态代理结束");
        return null;
    }


    public static void main(String[] args) {
//        System.out.println("start");
//        TransformersDynamicProxy proxy=new TransformersDynamicProxy(new TransformersDynamicImpl());
//        TransformersDynamic tran= (TransformersDynamic)proxy.newProxyInstance();
//        System.out.println("调用方法");
//        tran.transCar();
//        System.out.println("--------");
//        tran.transMan();
//        System.out.println("over");
//        打印的proxy可以看出，这个对象并不是在创建时传入的TransformersDynamicImpl对象，
//        而是通过Proxy生成的动态代理对象。
//        到这里静态代理和动态代理的最基本原理已经说完了。但是这里还是需要说点其他的。

        System.out.println("start");
        TransformersDynamicProxy dynamicProxy = new TransformersDynamicProxy(new TransformersDynamicImpl());
        TransformersDynamic proxy = (TransformersDynamic) dynamicProxy.newProxyInstance();
        System.out.println("调用方法"+ proxy.getClass());
        proxy.transMan();
        System.out.println("over");
//        从结果分析可以看出来，在输出transform to car前后少了一对before和after，
//        也就意味着这个时候transCar没有被增强，为什么呢，transCar是被增强的啊。
//        这里需要理解的是，在transMan中调用transCar方法前面还隐含着一个调用对象，补全就是this.
//         transCar()，也就是当前对象调用的transCar方法，并不是代理对象调用，
//        那就肯定没有增强逻辑的执行了。代理被绕过，没有生效。在这里有这个问题，那么对于Spring AOP的动态代理有没有问题呢？



    }
}
