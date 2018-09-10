package com.example.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private User user;

    private DruidDataSource dataSource;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DruidDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 打印属性值
     */
    public void printUserInfo() {
        logger.info("User属性值：userName = {}, age = {}, address = {}", user.getUserName(), user.getAge(), user.getAddress());
    }

    /**
     * 从数据库获取数据
     */
    public void selectUser() {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("select * from user_basic");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                logger.info("从数据库查询的结果为：userName = {}", rs.getString("user_name"));
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
