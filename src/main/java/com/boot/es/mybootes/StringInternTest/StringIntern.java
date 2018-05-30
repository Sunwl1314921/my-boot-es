package com.boot.es.mybootes.StringInternTest;

/***
 * string intern()的用法
 * 参考：https://monkeysayhi.github.io/2017/12/15/String%E5%B8%B8%E9%87%8F%E6%B1%A0%E5%92%8CString-intern/
 */
public class StringIntern {

    public static void main(String[] args) {
        String s1="ad";
        String s2 =new String("ad");
        System.out.println(s1==s2);
        System.out.println("--------");
        s1.intern();
        System.out.println(s1==s2);  //false

        System.out.println("========");
        String s5=new String("a")+new String("s");
        s5.intern();  //intern()的用法
        String s6 ="as";
        System.out.println(s5 == s6);//true
    }
}
