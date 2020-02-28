package com.application.event.listener.demo.listener;

import com.application.event.listener.demo.bean.UserBean;
import com.application.event.listener.demo.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserEmailListener {
    /**
     * 发送邮件监听实现
     *
     * @param userRegisterEvent 用户注册事件
     */
    @EventListener
    public void sendMail(UserRegisterEvent userRegisterEvent) {
        //获取注册用户对象
        UserBean user = userRegisterEvent.getUser();
        System.out.println("用户注册成功，发送邮件。用户名：" + user.getName() + "，密码：" + user.getPassword());
    }
}
