package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil3 {

    // 数据库连接url地址
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    // 数据库账号
    private static final String USERNAME = "root";
    // 数据库密码
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 获取数据库连接池，由连接池获取连接
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection = ds.getConnection();
            System.out.println(connection);

            String sql = "insert into exam_result" +
                    "(id,name,chinese,math,english)" +
                    " values (?,?,?,?,?)";
            // 根据连接创建SQL操作对象Statement
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setString(2, "ABC");
            statement.setBigDecimal(3, new BigDecimal("60"));
            statement.setBigDecimal(4, new BigDecimal("61"));
            statement.setBigDecimal(5, new BigDecimal("62"));
            // ResultSet类似List<Map<String, Object>>
            System.out.println(sql);
            // 根据操作对象Statement执行sql语句，返回结果集ResultSet
            int num = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
