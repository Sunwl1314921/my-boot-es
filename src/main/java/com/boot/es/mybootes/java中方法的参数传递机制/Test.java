package com.boot.es.mybootes.java中方法的参数传递机制;

public class Test {

    public static void main(String[] args) {
        int num  =30;
        System.out.println("num的值是："+num);
        change(num);
        System.out.println("num改编后的值是："+num);

//        Integer a=6,b=9;
//        change(a,b);
//        System.out.println("a:"+a+",b:"+b);

//        Hell hell=new Hell();
//        hell.setA(6);
//        hell.setB(9);
//        change(hell);
//        System.out.println("交换后的值：a:"+hell.getA()+",b:"+hell.getB());
    }
    static void change(Hell hell){
        int tem =hell.getA();
        hell.setA(hell.getB());
        hell.setB(tem);
        System.out.println("change交换时的值：a:"+hell.getA()+",b:"+hell.getB());
    }


    static void change(Integer a,int b){
        int tem =a;
        a=b;
        b=a;
        System.out.println("a:"+a+",b:"+b);
    }

    static void change(int num){
        num =100;
        System.out.println("num改编中的值是："+num);
    }
}
