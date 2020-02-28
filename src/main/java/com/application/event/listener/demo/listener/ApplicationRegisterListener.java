package com.application.event.listener.demo.listener;

import com.application.event.listener.demo.bean.UserBean;
import com.application.event.listener.demo.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRegisterListener implements ApplicationListener<UserRegisterEvent> {
    /**
     * 实现监听
     *
     * @param userRegisterEvent
     */
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        //获取注册用户对象
        UserBean user = userRegisterEvent.getUser();

        //../省略逻辑

        //输出注册用户信息
        System.out.println("ApplicationRegisterListener->注册信息，用户名：" + user.getName() + "，密码：" + user.getPassword());
    }

}