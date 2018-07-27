package com.boot.es.mybootes.HashMap相关;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestRemoveList {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("es1");
        list.add("es2");

//        for (Object obj : list) {
//            if (obj.equals("es2")) {
//                list.remove(obj);
//            }
//            if (obj.equals("es1")) {
//                System.out.println("result:" + obj);
//            }
//        }

        for (int i = 0; i < list.size(); i++) {
            String obj = (String) list.get(i);
            if (obj.equals("es1")) {
                list.remove(obj);
            }
            if (obj.equals("es2")) {
                System.out.println("result:" + obj);
            }
        }
//
//        for (int i = 0; i < list.size(); i++) {
//            String obj = (String) list.get(i);
//            if (obj.equals("es1")) {
//                list.remove(obj);
//            }
//            String obj2 = (String) list.get(i);
//            if (obj2.equals("es2")) {
//                System.out.println("result:" + obj2);
//            }
//        }
    }

}

class Test2 {
    private static List list = new ArrayList();
    private static Boolean isListUpdated = false;

    public static void main(String[] args) {
        list.add("es1");
        list.add("es2");

        new Thread(() -> {
            list.add("es3");
            isListUpdated = true;
        }).start();

        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            while (!isListUpdated) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            iterator.next();
        }
    }

}
