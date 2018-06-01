package com.boot.es.mybootes.Volatile;
import com.boot.es.mybootes.yuanma.ArrayListTest;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

/**
 * volatile只能保证可见性，不能保证原子性，只有当：
 * 1.多读单写时可以使用，这里的单写是指做复合操作的线程仅有1个；
 * 2.或者写入操作不依赖之前的值，即直接写入
 * 3.或者只是想访问变量时不加锁
 */

//线程安全的类在操作更新变量时，一定能保证更新结果对其他线程的可见性。
//而仅有可见性的变量，在做复合操作（通常会产生“竞态条件”）时，虽然能保证可见性，
//但由于不能保证原子性（可以了解下as-if-serial这个概念，及并发运行与串行执行结果一致），
//因此在不恰当的调度线程执行时，得到错误的结果，所以不是线程安全的
public class VolatileLearn {

    private volatile boolean flag = true;

    // 期望run只运行一次，对flag进行getAndOperate操作，此时使用volatile是危险的
    void run() {
        if (flag) {
            System.out.println("do something");
            flag = false;
        }
    }

    public static void main(String[] args) throws Exception {
//        test();
//
//        String introspection=Introspector.decapitalize("VolatileLearn");

        ArrayListTest h1 = new ArrayListTest(2, "haha");
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("age", ArrayListTest.class);
        Method method = propertyDescriptor.getReadMethod();
        Object o = method.invoke(h1);
        System.out.println(o);

        Method m2 = propertyDescriptor.getWriteMethod();
        m2.invoke(h1, 12);
        System.out.println(h1.getAge());

    }

    static void test() {
        VolatileLearn vl = new VolatileLearn();
        int capacity = 10;
        CountDownLatch cdl = new CountDownLatch(1);
        // 实际情况中，无法确认以下代码run会执行多少次
        for (int i = 0; i < capacity; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        cdl.await();
                        vl.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                ;
            };
            t.start();
        }
        cdl.countDown();
    }

}
