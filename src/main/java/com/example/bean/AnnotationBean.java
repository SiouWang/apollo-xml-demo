package com.example.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBean {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationBean.class);

    @Value("${jdbc.driver.class.name}")
    private String driverName;

    public void printConfig() {
        logger.info("driverName = {}", driverName);
    }
}
