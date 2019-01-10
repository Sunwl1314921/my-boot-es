package com.stream.source.user;

import com.stream.source.user.services.Error;
import com.stream.source.user.services.Message;
import com.stream.source.user.services.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding(value = { Processor.class })
@SpringBootApplication
public class UserApplication {


//    public static void main(String[] args) {
////        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class);
////        // 注册处理函数
////        System.out.println("注册结果：" + setHander(context));
////        // 发送消息
////        System.out.println("发送结果：" + write(context));
////    }
////
////    // 发送消息
////    public static boolean write(ConfigurableApplicationContext context) {
////        Service service = context.getBean(Service.class);
////        return service.write("狗子在吗?");
////    }
////
////    // 注册接收到消息时的处理函数
////    public static boolean setHander(ConfigurableApplicationContext context) {
////        Service service = context.getBean(Service.class);
////        return service.subscribe(result -> {
////            System.out.print("狗子收到消息：" + result.getPayload());
////        });
////    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class);
        // 发送消息
        Message message = new Message();
        message.setAll(200);
        message.setMessage("狗子在吗？");
        Error error = new Error();
        error.setError("错误呼唤！");
        write(context, message);
        write(context, error);
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['contentType']=='Message'")
    public void handler1(@Payload Message message, @Header("contentType") String header) {
        System.out.println("狗子收到message消息1：" + message.getMessage());
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['contentType']=='Error'")
    public void handler2(Error message) {
        System.out.print("狗子收到error消息2：" + message.getError());
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['contentType']=='Message'")
    public void handler3(@Payload Message message, @Header("contentType") String header) {
        System.out.println("狗子收到message消息3：" + message.getMessage());
    }

    // 发送消息
    public static boolean write(ConfigurableApplicationContext context, Object data) {
        Service service = context.getBean(Service.class);
        return service.write(data);
    }
}
