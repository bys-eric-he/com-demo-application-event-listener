package com.application.event.listener.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComDemoApplicationEventListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComDemoApplicationEventListenerApplication.class, args);
        System.out.println("http://127.0.0.1:8080/register?name=admin&password=123456");
    }

}
