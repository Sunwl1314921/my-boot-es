package com.boot.es.mybootes.fanshe;

import org.apache.http.impl.execchain.TunnelRefusedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestStudent {

    public static void main(String[] args)throws  Exception{
//        Student stu=new Student();
//
//        Class stClass1 = stu.getClass();
//
//        Class stuClass2 = Student.class;
//
//        System.out.println(stClass1 == stuClass2);
//
//        Class stuClass3 = Class.forName("com.boot.es.mybootes.fanshe.Student");
//
//        System.out.println(stClass1 == stuClass3);
//

//        System.out.println("---------------");
//
//        Class stuclass = Class.forName("com.boot.es.mybootes.fanshe.Student");
//        //获取public修饰的方法
//        Constructor[] con=stuclass.getConstructors();
//        for (Constructor cs:con){
//            System.out.println(cs);
//
//        }
//
//        System.out.println("================");
//        //获取所有方法包含public private修饰的方法
//        Constructor[] cons = stuclass.getDeclaredConstructors();
//        for (Constructor cs:cons){
//            System.out.println(cs);
//
//        }
//        System.out.println("-------获取无参public修饰的方法--------");
//        //获取无参public修饰的方法
//        Constructor constr = stuclass.getConstructor();
//        System.out.println(constr);
//        System.out.println("--------获取构造方法--------");
//        //获取构造方法
//        Object obj = stuclass.newInstance();
//        System.out.println(obj);
//        System.out.println("******************获取私有构造方法，并调用*******************************");
//        Constructor construe=stuclass.getDeclaredConstructor(String.class,int.class);
//        //调用构造方法
//        construe.setAccessible(true);//暴力访问(忽略掉访问修饰符)
//
//        obj = construe.newInstance("swl",26);
//        System.out.println(obj);

        System.out.println("-----测试mian方法的反射------");
        Class clazz = Class.forName("com.boot.es.mybootes.fanshe.Student");
        System.out.println("clazz:"+clazz);
        //  获取main方法
        Method method = clazz.getMethod("main",String[].class);
        //调用main方法
        //第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，
        // 这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
        //这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。
        method.invoke("null",(Object) new String[]{"a","b"});//方式一

        method.invoke(null,new Object[]{new String[]{"a","b","c"}});//方式二
    }
}
