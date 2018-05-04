package com.boot.es.mybootes.fanshe.shuzu;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestShuZu {

    public static void main(String[] args) {
        int [] a1=new int[3];
        int [] a2=new int[3];
        int [] a3=new int[4];
        int [] [] a4=new int[3][4];
        int [] [] a5=new int[3][4];
        String [] a6=new String[3];
        String [] a7=new String[3];

        System.out.println(a1.getClass() == a2.getClass());
        System.out.println(a1.getClass() == a3.getClass());
        System.out.println(a4.getClass() == a5.getClass());
        System.out.println(a7.getClass() == a6.getClass());
        System.out.println(a7.getClass().getName());
        System.out.println(a1.getClass().getName());

        int [] a8=new int[]{1,2,3};
        String [] a9=new String[]{"a","b","c"};
        System.out.println(Arrays.asList(a8));
        System.out.println(Arrays.asList(a9));
//        运行结果是：
//        [[I@17e4ca]
//        [a, b, c]

        //原因
//        可以明显看出String类型的数组遍历出来了，
//        但int类型的数组却没有。原因是String类型的数组接收后会作为一个Object类型进行处理，
//        也就是jdk1.4进行处理掉了，但因为int是基本类型，所以int类型的数组传进去后不会作为Object类型进行处理，
//        所以只能jdk1.5去处理，而jdk1.5就会把int类型的数组作为一个参数去处理，所以得不到数组中的各个元素的遍历结果。
//        这就是jdk1.4与jdk1.5的差异，在jdk1.4中asList()的参数是Object[]类型的
//        pubic static <T>List<T> asList(Object[]  a)
//        但在jdk1.5中asList()方法的定义变成下面这样：
//        pubic static <T>List<T> asList(T...  a)，返回的是个fixed-size
//        由此产生的在A类中调用B类的mian()方法，mian()方法的参数如果是Object[]类型，例如参数为String[]{"q","w","e"},
//        则在B的mian()方法运行就会去将参数拆分成"q"、"w"、"e"三个参数，（这就是为了兼容jdk1.4），因此就会造成参数个数不一致，
//        解决方案有下面两种：(推荐2)
//        （1）在外面在包装一个Object，因为只拆分一次，包装后拆分结果还是一个String数组，即：String[]{"q","w","e"}
//        （2）直接强制类型转换，不进行拆分数组，即：(Object)newString[]{"q","w","e"}


        int len= Array.getLength(a8);
        for (int i=0;i<len;i++){
            System.out.println(Array.get(a8,i));
        }
    }
}
