package com.example;

import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService) context.getBean("userService");

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            us.selectUser();
            us.printUserInfo();

        }

    }

}
