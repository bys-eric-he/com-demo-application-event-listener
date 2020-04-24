package com.application.event.listener.demo;

import com.application.event.listener.demo.bean.UserBean;
import com.application.event.listener.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ComDemoApplicationEventListenerApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ComDemoApplicationEventListenerApplication.class, args);
        System.out.println("http://127.0.0.1:8080/register?name=admin&password=123456");
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void publishEvent() {
        UserBean user = new UserBean();
        user.setName("ERIC.HE");
        user.setPassword("1994");
        userService.register(user);
    }
}
