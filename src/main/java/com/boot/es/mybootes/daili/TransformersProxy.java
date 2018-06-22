package com.boot.es.mybootes.daili;

/**
 * 代理类TransformersProxy，和TransformersImpl一样都要实现Transformers接
 */
public class TransformersProxy implements Transformers {

    private Transformers transformers;

    public void init(Object trans){//初始化
        this.transformers = (Transformers)trans;
    }

    @Override
    public void transMan() {
        transformers.transMan();
        System.out.println("代理类的机器人接口");
    }

    @Override
    public void transCar() {
        transformers.transCar();
        System.out.println("代理类的超级车接口");
    }

    /**
     * 测试方法
     *
     * 先执行代理类中的逻辑，再执行目标方法，这样就完成了代理的过程。
     * 如果现在又有一个变形金刚大黄蜂实现了Transformers类，它的增强内容和擎天柱是相同，
     * 这个时候代理类中的增强代码就可复用，只要在初始化代理对象的时候，传入大黄蜂实现类对象即可。
     *
     * 缺点：
     * 随着项目的迭代升级，代理的目标增多，代理的增强内容变多(可能不同的实现类需要增强的内容不同),
     * 代理类也会越来越庞大，对整个维护过程也会变得复杂。
     */
    public static void main(String[] args) {
        System.out.println("测试静态代理方法开始");
        TransformersProxy proxy=new TransformersProxy();
        proxy.init(new TransformersImpl());

        proxy.transMan();
        System.out.println("---------");
        proxy.transCar();
    }
}
