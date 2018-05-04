package com.boot.es.mybootes.fanshe.shuzu;

/**
 * 定义两个integer对象交换参数
 */
public class Jiaohuan {
    public static void main(String[] args) throws Exception {
        Integer a = 12;
        Integer b = 15;

        System.out.println("a=" + a + "----b=" + b);

        System.out.println("交换位置");
        swap(a, b);
        System.out.println("a=" + a + "----b=" + b);
        //扫盲
        int c= 3|5;
        System.out.println(c);
        int d=7^5;
        System.out.println(d);
    }

    private static void swap(Integer a, Integer b) throws Exception {
//        Class clazz = a.getClass();
////        Field field = clazz.getDeclaredField("value");
////        field.setAccessible(true);
////        Object oa = field.get(a);
////        Object ob = field.get(b);
////        field.set(a,ob);
////        field.set(b,oa);
        //方式二
        Integer c=a;
        a=b;
        b=c;
        System.out.println("a=" + a + "----b=" + b);
        System.exit(1);

    }
}
