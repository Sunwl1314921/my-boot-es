package com.boot.es.mybootes.fanshe;

import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.reflect.Method;

/*
 * 获取成员方法并调用：
 * 1.批量的：
 *      public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 *      public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 *      public Method getMethod(String name,Class<?>... parameterTypes):
 *                  参数：
 *                      name : 方法名；
 *                      Class ... : 形参的Class类型对象
 *      public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 *   调用方法：
 *      Method --> public Object invoke(Object obj,Object... args):
 *                  参数说明：
 *                  obj : 要调用方法的对象；
 *                  args:调用方式时所传递的实参；
 */
public class Testpeople {
    public static void main(String[] args) throws Exception {
        System.out.println("获取所有公有方法");
        Class clazz = Class.forName("com.boot.es.mybootes.fanshe.People");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method method = clazz.getMethod("show1", String.class);
        System.out.println(method);
        //实例化一个Student对象
        Object obj = clazz.getConstructor().newInstance();
        method.invoke(obj, "刘德华");

        System.out.println("***************获取私有的show4()方法*******************");
        Method method1 = clazz.getDeclaredMethod("show4", int.class);
        System.out.println(method1);
        method1.setAccessible(true);//解除私有限定
        method1.invoke(obj, 12);


//        System.out.println("mian方法的反射");
//        Method mianMethod = clazz.getMethod("main",String[].class);
//        mianMethod.invoke(null,"a","b","c");
    }
}
