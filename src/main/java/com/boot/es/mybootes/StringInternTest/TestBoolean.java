package com.boot.es.mybootes.StringInternTest;

/**
 *  如果有三个Bool型变量，
 *  请写出一程序得知其中有2个以上变量的值是true
 * https://mp.weixin.qq.com/s/Hd5i83CV8kk7uBMw0UMdcw
 */
public class TestBoolean {
    public static void main(String[] args) {
//        boolean a=false;
//        boolean b=false;
//        boolean c= true;

        boolean a=true;
        boolean b=true;
        boolean c= false;

        System.out.println(a && b);
        System.out.println(a && c);
        System.out.println(b && c);
        System.out.println(atLeastTwo(a,b,c));
    }


    static boolean atLeastTwo(boolean a, boolean b, boolean c) {
        return a ^ b ? c : a;
//        if ((a && b) || (b && c) || (a && c)) {
//            return true;
//        } else {
//            return false;
//        }
    }

}
