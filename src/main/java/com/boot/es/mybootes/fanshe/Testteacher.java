package com.boot.es.mybootes.fanshe;

import java.lang.reflect.Field;

public class Testteacher {
    /*
     * 获取成员变量并调用：
     * 1.批量的
     *      1).Field[] getFields():获取所有的"公有字段"
     *      2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * 2.获取单个的：
     *      1).public Field getField(String fieldName):获取某个"公有的"字段；
     *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     *   设置字段的值：
     *      Field --> public void set(Object obj,Object value):
     *                  参数说明：
     *                  1.obj:要设置的字段所在的对象；
     *                  2.value:要为字段设置的值；
     */
    public static void main(String[] args) throws  Exception{
        Class teClass = Class.forName("com.boot.es.mybootes.fanshe.Teacher");

        System.out.println("获取所有公有字段");
        Field[] fielsPublic = teClass.getFields();
        for (Field o: fielsPublic){
            System.out.println(o);
        }
        System.out.println("获取所有字段");
        Field[] allField = teClass.getDeclaredFields();
        for (Field o: allField){
            System.out.println(o);
        }

        System.out.println("获取公有字段**并调用");
        Field fieldPublic =teClass.getField("name");
        System.out.println(fieldPublic);
        Object obj = teClass.getConstructor().newInstance();
        fieldPublic.set(obj,"swl");
        Teacher tea = (Teacher) obj;
        System.out.println(tea.name);
        System.out.println("**************获取私有字段****并调用********************************");

        Field fieldprivate = teClass.getDeclaredField("phoneNum");
        System.out.println(fieldprivate);
        fieldprivate.setAccessible(true);//暴力访问
        fieldprivate.set(obj,"1234");
        System.out.println(tea);


    }
}
