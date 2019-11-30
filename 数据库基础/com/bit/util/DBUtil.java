package com.bit.util;

import java.math.BigDecimal;
import java.sql.*;

public class DBUtil {

    // 数据库连接url地址
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    // 数据库账号
    private static final String USERNAME = "root";
    // 数据库密码
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        String input = "'孙悟空' or 1=1";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取数据库连接
            connection = DriverManager
                    .getConnection(URL, USERNAME, PASSWORD);
            System.out.println(connection);
            // 根据连接创建SQL操作对象Statement
            statement = connection.createStatement();
            String sql = "select id,name,chinese,math,english" +
                    " from exam_result where name="+input;
            // ResultSet类似List<Map<String, Object>>
            System.out.println(sql);
            // 根据操作对象Statement执行sql语句，返回结果集ResultSet
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int        id = resultSet.getInt("id");
                String     name = resultSet.getString("name");
                BigDecimal chinese = resultSet.getBigDecimal("chinese");
                BigDecimal math = resultSet.getBigDecimal("math");
                BigDecimal english = resultSet.getBigDecimal("english");
                System.out.printf("id=%s,name=%s,chinese=%s,math=%s" +
                        ",english=%s", id, name, chinese, math, english);
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if(resultSet != null)
                    resultSet.close();
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
