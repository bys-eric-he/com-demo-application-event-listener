package com.application.event.listener.demo.listener;

import com.application.event.listener.demo.bean.UserBean;
import com.application.event.listener.demo.event.UserRegisterEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 注意：如果存在多个监听同一个事件时，并且存在异步与同步同时存在时则不存在执行顺序。
 */
@Component
public class ApplicationAsyncRegisterListener implements ApplicationListener<UserRegisterEvent> {
    /**
     * supportsEventType & supportsSourceType 两个方法返回true时调用该方法执行业务逻辑
     *
     * @param userRegisterEvent 具体监听实例，这里是UserRegisterEvent
     */
    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        try {
            Thread.sleep(3000);//静静的沉睡3秒钟
        } catch (Exception e) {
            e.printStackTrace();
        }
        //转换事件类型
        //UserRegisterEvent userRegisterEvent = (UserRegisterEvent) applicationEvent;
        //获取注册用户对象信息
        UserBean user = userRegisterEvent.getUser();
        ;
        System.out.println("线程：" + Thread.currentThread().getName() + " 静静的沉睡3秒钟,ApplicationAsyncRegisterListener->用户：" + user.getName() + "，注册成功，发送邮件通知。");
    }
}
