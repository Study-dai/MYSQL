package com.bit.util;

import java.math.BigDecimal;
import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection(URL, USERNAME, PASSWORD);
            System.out.println(connection);
            statement = connection.createStatement();
            String sql = "select id,name,chinese,math,english" +
                    " from exam_result";
            // ResultSet类似List<Map<String, Object>>
            System.out.println(sql);
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
===============================================
connection 容器   connection.close（）；
                           关闭资源，不是真实关闭物理连接，而是把连接重置

1.建立数据库连接 DriverManager    DataSourse
简单SQL（Statement） 带占位符号（PreparedStatement）
存储过程（callableStatement）


2.创建操作对象
3.执行SQL语句
4.处理结果集
5.释放资源




CREATE TABLE student (
id INT NOT NULL,
sn INT,
name VARCHAR(20),
qq_mail VARCHAR(20)
);












