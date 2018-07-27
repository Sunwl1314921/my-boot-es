package com.boot.es.mybootes.HashMap相关;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class HashMap1 {

    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString() + 1);
                }
            }).start();
        }
        for (int i = 0; i < map.size(); i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (String in : map.keySet()) {
                        //map.keySet()返回的是所有key的值
                        String str = map.get(in);//得到每个key多对用value的值
                        System.out.println(in + "     " + str);
                    }

                }
            }).start();
        }

        System.out.println(map.size());
    }

}
