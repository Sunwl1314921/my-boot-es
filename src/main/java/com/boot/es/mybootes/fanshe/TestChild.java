package com.boot.es.mybootes.fanshe;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 * 利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 只需要将新类发送给客户端，并修改配置文件即可
 */
public class TestChild {
    static void wirte() throws Exception {
        //创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件
        //而且该文件会被创建到指定目录下，如果该目录下已有同名文件，将被覆盖
        //其实该步就是在明确数据要存放的目的地
        FileWriter fw = new FileWriter("src/main/java/com/boot/es/mybootes/fanshe/Demo.txt", true);
        //这里传递一个true参数，代表不覆盖已有的文件，并在已有文件的基础上维持进行数据续写
        //调用writer方法，将字符串写到流中
        fw.write("package=com.boot.es.mybootes.fanshe.Child");
        fw.write("\r\nmethod=show");
        //关闭流资源，但是在关闭之前会刷新一次内容的缓存中数据，将数据刷新到目的地中
        //和flush的区别：flush刷新后，流可以继续使用，而close刷新后，会将流关闭。
        fw.close();
    }

    //读取配置文件 的属性值 通过名字
    static String read(String name) throws Exception {
        Properties properties = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("src/main/java/com/boot/es/mybootes/fanshe/Demo.txt");//获取输入流
        properties.load(in);//将流加载到配置文件对象中
        in.close();
        return properties.getProperty(name);//返回根据key获取的value值
    }

    public static void main(String[] args) throws Exception {
        //先写入
        wirte();
        //再读取
        Class clazz = Class.forName(read("package"));
        System.out.println(clazz);
        Method method = clazz.getMethod(read("method"));
        System.out.println(method);
        method.invoke(clazz.getConstructor().newInstance());
    }
}
