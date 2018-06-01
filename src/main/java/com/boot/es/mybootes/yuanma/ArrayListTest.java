package com.boot.es.mybootes.yuanma;

import java.text.SimpleDateFormat;
import java.util.*;

public class ArrayListTest {

    private int age;

    private String name;

    public ArrayListTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Collection con = new Vector();
        //((Vector) con).add(0,"23");

        List list = new ArrayList(new Vector());
        for (Object obj : list) {
            System.out.println(obj);
        }


        //map 取值的方式
//        Map<String,String> map = new HashMap<>();
//        map.put("123","321");
//        map.put("aaa","vbbb");
//        //---------第一种方式-------
//        //        Iterator iterator = map.entrySet().iterator();
////        while(iterator.hasNext()){
////            Map.Entry entry= (Map.Entry)iterator.next();
////            System.out.println(entry.getKey());
////            System.out.println( entry.getValue());
////
////        }
//        for (Object o : map.entrySet()) {
//            Map.Entry entry = (Map.Entry) o;
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//
//        }
//        //---------第二种方式-------
//        for(Object o: map.keySet()){
//            System.out.println(o);
//            System.out.println(map.get(o));
//        }


        //ArrayList clone方法实例
        List list1 = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list1.add("list的数据" + i);
        }
//        System.out.println(list1.size());
//        ArrayList list2 = (ArrayList) ((ArrayList) list1).clone();
//        list2.forEach(ob -> System.out.println(ob));
        //toArray 方法 把list转换成object[]数组
//        Object[] obj= list1.toArray();
//        System.out.println(obj.length);
        //toArray(T[] a) 方法
        //返回一个数组(list的全部数据)，使用运行时确定类型，该数组包含在这个列表中的所有元素（从第一到最后一个元素）
        //如果a的length大于list的size 则把[size]置为空，其他超出部分值不变 返回的数组的长度为list和a中最大的长度值
        //返回的数组容量由参数和本数组中较大值确定
//        Object [] obj1= new Object[]{1,2,3,4,5,6};
//        Object [] obj2 = list1.toArray(obj1);
//        System.out.println(obj2.length);
//        for (int i=0;i<obj2.length;i++){
//            System.out.println(obj2[i]);
//        }

        //remove(int index) 方法测试
//        list1.forEach(ob -> System.out.println(ob));
//        Object obj = list1.remove(4);
//        System.out.println(obj);
//        list1.forEach(ob -> System.out.println(ob));


//        String atx="1,2,3,4";
//        List<String> itemCategoryIdList = Arrays.asList(atx.split(","));
//        List<Long> longs = new ArrayList<>();
//        for (String anItemCategoryIdList : itemCategoryIdList) {
//            if (!StringUtils.isEmpty(anItemCategoryIdList)) {
//                longs.add(Long.parseLong(anItemCategoryIdList));
//            }
//        }


        //把时间戳转换成时间
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long("1526387202000");
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        System.out.println(res);

        List lists=new LinkedList();

    }


}
