package com.boot.es.mybootes.paixu;

public class KuaiSuPaiXu {
    public static void main(String[] args) {
        int [] temp = {11,12,4,7,5,19};
        for(int i : temp){
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println("");
        quick_sort(temp,0,1);
        for(int i : temp){
            System.out.print(i);
            System.out.print(",");
        }
    }
    /*
     * 快速排序
     * 参数说明：
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    static  void quick_sort(int [] a,int l,int r){
            if (l < r){
                int i,j,x;

                i = l;
                j = r;
                x = a[i];
                while (i < j){
                    while(i < j && a[j] > x)
                        j--; // 从右向左找第一个小于x的数
                    if(i < j)
                        a[i++] = a[j];
                    while(i < j && a[i] < x)
                        i++; // 从左向右找第一个大于x的数
                    if(i < j)
                        a[j--] = a[i];
                }
                a[i] = x;
                quick_sort(a, l, i-1); /* 递归调用 */
                quick_sort(a, i+1, r); /* 递归调用 */
            }

    }
}
