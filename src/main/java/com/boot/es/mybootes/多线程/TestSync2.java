package com.boot.es.mybootes.多线程;

public class TestSync2 implements Runnable{
    int b =100;

    synchronized  void m1() throws  Exception{
        b =1000;
        Thread.sleep(500);
        System.out.println("m1中b的值为："+b); // 6
    }

    synchronized  void m2() throws  Exception{
        Thread.sleep(250);
        b =2000; //5
    }

    public static void main(String[] args) throws  Exception{
        TestSync2 t2=new TestSync2();
        Thread thread=new Thread(t2); // 1
        thread.start(); //2
        t2.m2(); //3
        System.out.println("mian 函数中b的值:"+t2.b); //4
    }

    @Override
    public void run(){
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
