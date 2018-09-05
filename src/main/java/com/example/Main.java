package com.example;

import com.example.service.PropertyService;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService) context.getBean("userService");
//        PropertyService ps = (PropertyService) context.getBean("propertyService");
//        while(true) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            ps.getConfig();
//        }
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            us.selectUser();
        }


    }

}
