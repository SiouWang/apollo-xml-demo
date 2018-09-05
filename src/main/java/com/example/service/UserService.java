package com.example.service;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

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
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("select * from user_basic");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("从数据库查询的结果为：userName = " + rs.getString("user_name"));
            }
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
