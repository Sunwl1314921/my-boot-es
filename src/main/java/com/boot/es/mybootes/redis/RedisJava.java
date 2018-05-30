package com.boot.es.mybootes.redis;

import java.util.ArrayList;
import java.util.List;

public class RedisJava {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
//        Jedis jedis =new Jedis("127.0.0.1",6379);
//        jedis.auth("swl19930208");//设置登陆密码
//
//        //检查链接状态
//        System.out.println("链接成功");
//        System.out.println("查看服务是否启动"+jedis.ping());
//
//        //操作string字符串
//        jedis.set("name","swl");
//        System.out.println("java操作string字符串"+jedis.get("name"));
//
//        //操作Java List(列表)实例 以先进后出格式存储
//        jedis.lpush("list","redis");
//        jedis.lpush("list","memcached");
//        jedis.lpush("list","caches");
//        jedis.lpush("list","mysql");
//        List list = jedis.lrange("list",0,2);
//        list.forEach(it -> System.out.println(it));
//
//        //操作Java Keys 实例
//        // 获取数据并输出
//        Set<String> keys= jedis.keys("*");
//        Iterator<String> it=keys.iterator();
//        while(it.hasNext()) {
//            String key=it.next();
//            System.out.println("key");
//        }

        long start = System.currentTimeMillis();
        List list=new ArrayList(1000000);
        for (int i=0;i<1000000;i++){
            list.add(i);
        }

        long end =System.currentTimeMillis();

        System.out.println("耗时："+(end-start));


    }
}
