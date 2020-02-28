package com.application.event.listener.demo.listener;

import com.application.event.listener.demo.bean.UserBean;
import com.application.event.listener.demo.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件发布可以存在多个监听，事件发布者不用考虑具体哪个监听去处理业务。
 * 但事件监听是无序的，监听到的事件先后顺序完全随机出现的。
 */
@Component
public class UserRegisterListener {
    /**
     * 注册监听实现方法
     *
     * @param userRegisterEvent 用户注册事件
     */
    @EventListener
    public void register(UserRegisterEvent userRegisterEvent) {
        //获取注册用户对象
        UserBean user = userRegisterEvent.getUser();

        //输出注册用户信息
        System.out.println("@EventListener注册信息，用户名：" + user.getName() + "，密码：" + user.getPassword());
    }
}
