package com.application.event.listener.demo.service;

import com.application.event.listener.demo.bean.UserBean;
import com.application.event.listener.demo.event.UserRegisterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 我们在传统项目中往往各个业务逻辑之间耦合性较强，
 * 因为我们在service都是直接引用的关联service或者jpa来作为协作处理逻辑，
 * 然而这种方式在后期更新、维护性难度都是大大提高了。然而我们采用事件通知、事件监听形式来处理逻辑时耦合性则是可以降到最小。
 */
@Service
public class UserService {
    /**
     * 事件发布是由ApplicationContext对象管控的，
     * 我们发布事件前需要注入ApplicationContext对象调用publishEvent方法完成事件发布。
     */
    @Autowired
    ApplicationContext applicationContext;

    /**
     * 用户注册方法
     *
     * @param user
     */
    public void register(UserBean user) {
        //发布UserRegisterEvent事件
        applicationContext.publishEvent(new UserRegisterEvent(this, user));
    }
}
