package com.boot.es.mybootes.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestFanshe4 {

    private  String name;
    private  int age;

    public TestFanshe4(String name,int age){
        this.age=age;
        this.name=name;
    }

    public void getName(){
        System.out.println(name);
    }


}

class  test{
    public static void main(String[] args) throws  Exception{
        TestFanshe4 tf =new TestFanshe4("死亡率",26);

//        Method[] methods = tf.getClass().getDeclaredMethods();
//        for (int i = 0; i < methods.length; i++) {
//            System.out.println(methods[i]);
//        }
//
//        System.out.println("---------------");
//        Field[] fields = tf.getClass().getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//            fields[i].setAccessible(true);
//            System.out.println(fields[i].getName()+fields[i].get(tf)+fields[i].getType());
//        }

        Class<?> clazz = Class.forName("com.boot.es.mybootes.fanshe.TestFanshe4");

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

        System.out.println("---------------");
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            System.out.println(fields[i].getName()+fields[i].get(tf)+fields[i].getType());
        }

    }
}
