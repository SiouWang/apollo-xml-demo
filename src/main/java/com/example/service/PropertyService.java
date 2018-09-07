package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class PropertyService {

    private static final Logger logger = LoggerFactory.getLogger(PropertyService.class);

    /**
     * 在xml文件中指定值
     */
    private String dbName;

    /**
     * 在xml文件中指定值
     */
    private String dbUrl;

    /**
     * 未在xml中指定值
     * 混合使用@Value
     */
    @Value("${serverName: default value}")
    private String serverName;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void getConfig() {
        logger.info("dbName = {}，dbUrl = {}，serverName = {}", dbName, dbUrl, serverName);
    }

}
