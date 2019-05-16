package com.boot.security.mybootsecurity.io_learn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {

    private static String url = "C:\\Users\\Administrator\\Desktop\\my-boot-es\\my-boot-security\\src\\main\\java\\com\\boot\\security\\mybootsecurity\\io_learn\\";

    //利用通道完成文件的复制(非直接缓冲区)
    public static  void test1() throws  Exception{
        FileInputStream fi  = new FileInputStream(url+"1.jpg");
        FileOutputStream fo = new FileOutputStream(url+"2.jpg");
        //获取通道
        FileChannel fic  = fi.getChannel();
        FileChannel fco = fo.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer bf = ByteBuffer.allocate(1024);

        //将通道中数据存入缓冲区
        while(fic.read(bf) >-1){
            bf.flip();//切换到读数据的模式
            //将缓冲区中的数据写入通道中
            fco.write(bf);

            bf.clear();//清空缓冲区
        }

        //关闭
        fco.close();
        fic.close();
        fo.close();
        fi.close();
    }

    //使用直接缓冲区完成文件的复制 (内存映射文件)
    public static void test2 () throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get(url+"3.jpg"), StandardOpenOption.READ);
        FileChannel ouChannel = FileChannel.open(Paths.get(url+"5.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.READ);//不存在就创建

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuf = ouChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //直接对缓冲区的数据读写
        byte[] b = new byte[inMappedBuf.limit()];
        inMappedBuf.get(b);
        outMappedBuf.put(b);

        inChannel.close();
        ouChannel.close();
    }

    public static void test3() throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get(url+"3.jpg"), StandardOpenOption.READ);
        FileChannel ouChannel = FileChannel.open(Paths.get(url+"6.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.READ);//不存在就创建
        inChannel.transferTo(0,inChannel.size(),ouChannel);
        inChannel.close();
        ouChannel.close();
    }


    public static void main(String[] args) throws  Exception{
        test3();
    }
}
