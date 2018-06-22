package com.boot.es.mybootes.daili;

/**
 * 创建一个接口Transformers(变形金刚)
 */
public interface Transformers {

    void transMan();//变成人

    void transCar();//变成车

    /**
     * 代理模式
     * 代理模式分为静态代理和动态代理两种方式，
     * 静态代理是在开发的时候就写好代理的过程，并且代理类要和目标类实现同一个接口。
     * 而动态代理是代理类通过实现InvocationHandler接口完成，在运行期间动态的构建代理对象，
     * 在动态代理的实现过程中还有另一个更为重要的类Proxy，确的来说，Proxy负责生成代理对象，
     * 而InvocationHandler是根据生成的代理对象执行增强内容和目标方法或类。
     *
     * 静态代理
     * 要点：
     * 1、代理类需要和目标类需要实现同一个接口
     * 2、在代理类中会内置目标类对象
     */
}
