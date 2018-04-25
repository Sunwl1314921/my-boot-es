package com.boot.es.mybootes.fanshe;

import org.apache.http.impl.execchain.TunnelRefusedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test {

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

        System.out.println("---------------");

        Class stuclass = Class.forName("com.boot.es.mybootes.fanshe.Student");
        //获取public修饰的方法
        Constructor[] con=stuclass.getConstructors();
        for (Constructor cs:con){
            System.out.println(cs);

        }

        System.out.println("================");
        //获取所有方法包含public private修饰的方法
        Constructor[] cons = stuclass.getDeclaredConstructors();
        for (Constructor cs:cons){
            System.out.println(cs);

        }
        System.out.println("-------获取无参public修饰的方法--------");
        //获取无参public修饰的方法
        Constructor constr = stuclass.getConstructor();
        System.out.println(constr);
        System.out.println("--------获取构造方法--------");
        //获取构造方法
        Object obj = stuclass.newInstance();
        System.out.println(obj);
        System.out.println("******************获取私有构造方法，并调用*******************************");
        Constructor construe=stuclass.getDeclaredConstructor(String.class,int.class);
        //调用构造方法
        construe.setAccessible(true);//暴力访问(忽略掉访问修饰符)

        obj = construe.newInstance("swl",26);
        System.out.println(obj);


    }
}
