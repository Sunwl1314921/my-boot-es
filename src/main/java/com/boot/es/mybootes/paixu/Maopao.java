package com.boot.es.mybootes.paixu;

/**
 * 参考：https://mp.weixin.qq.com/s?__biz=MzU2MTI4MjI0MQ==&mid=2247483704&idx=1&sn=3d056587972675ba725c0ef2c2632709&chksm=fc7a6c96cb0de580be5cf813443f1116a8a7c31450e36de146006933f9ffd21c60286e68bdc0&scene=21#wechat_redirect
 * 冒泡排序(Bubble Sort)，又被称为气泡排序或泡沫排序
 * 它是一种较简单的排序算法。它会遍历若干次要排序的数列，
 * 每次遍历时，它都会从前往后依次的比较相邻两个数的大小；
 * 如果前者比后者大，则交换它们的位置。这样，一次遍历之后，
 * 最大的元素就在数列的末尾！ 采用相同的方法再次遍历时，
 * 第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！
 */
public class Maopao {
    public static void main(String[] args) {
        int [] temp = {11,12,4,7,5,19};
        for(int i : temp){
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println("");
        maopao(temp);
        for(int i : temp){
            System.out.print(i);
            System.out.print(",");
        }
    }

    static void maopao(int [] temp){
        int tem = 0;
        for(int i =0;i<temp.length;i++){
            for(int j=i+1;j<temp.length;j++){
                if(temp[i]>temp[j]){
                    tem = temp[j];
                    temp[j]= temp[i];
                    temp[i]=tem;
                }
            }
        }
    }
}
