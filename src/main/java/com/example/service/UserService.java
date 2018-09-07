package com.example.service;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private DruidDataSource dataSource;

    public DruidDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void selectUser() {
        Connection conn = null;
        PreparedStatement ps = null;
        logger.info("连接计数：{} | initialSize={} | maxActive={} | minIdle={} | maxWait={} | validationQuery={} | testWhileIdle={} | timeBetweenEvictionRunsMillis={} | testOnBorrow={} | testOnReturn={}",
                dataSource.getConnectCount(),
                dataSource.getInitialSize(), dataSource.getMaxActive(), dataSource.getMinIdle(), dataSource.getMaxWait(), dataSource.getValidationQuery(), null, dataSource.getTimeBetweenEvictionRunsMillis());




        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("select * from user_basic");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("从数据库查询的结果为：userName = " + rs.getString("user_name"));
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            try {
                ps.close();
            } catch (SQLException e1) {
                try {
                    conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
                e1.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
