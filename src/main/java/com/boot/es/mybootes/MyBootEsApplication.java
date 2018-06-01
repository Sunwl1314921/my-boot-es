package com.boot.es.mybootes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MyBootEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBootEsApplication.class, args);
    }

}
