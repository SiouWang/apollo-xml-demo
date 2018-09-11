package com.example;

import com.example.bean.AnnotationBean;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 使用传统xml配置的bean
        UserService us = (UserService) context.getBean("userService");
        // 使用注解获取配置的Bean
        AnnotationBean ab = context.getBean(AnnotationBean.class);


        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 从apollo获取配置初始化连接池，从数据库获取数据
            us.selectUser();
            // 从apollo获取配置，在xml中使用占位符获取配置值
            us.printUserInfo();
            // 从apollo获取配置，使用注解获取配置值
            ab.printConfig();

        }

    }

}
