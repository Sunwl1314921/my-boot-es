package com.boot.es.mybootes.ceshiJMH;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * JMH微基准测试
 * http://www.importnew.com/12548.html
 */

public class MyPro {

    public static void main(String [] args) throws Exception{
        Options opt = new OptionsBuilder()
                .include(JmhDemo.class.getSimpleName())
                .forks(1)
                .warmupIterations(5) //预热次数
                .measurementIterations(5) //真正执行次数
                .build();

        new Runner(opt).run();
    }

}