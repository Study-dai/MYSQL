package com.dai.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;

public class DButil3 {
    private static final String URL="jdbc:mysql://localhost:3306/dai32mall";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    public static void main(String[] args)  {
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            //获取数据库连接池，由连接池获取连接
            DataSource ds=new MysqlDataSource();
            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection=ds.getConnection();
            System.out.println(connection); 

            String sql="insert into exam_result" +
                    " (id,name,chinese,math,english)" +
                    " values(?,?,?,?,?)";
            //根据连接创建SQL操作对象statement
            statement=connection.prepareStatement(sql);
            statement.setInt(1,1);
            statement.setString(2,"ABC");
            statement.setBigDecimal(3,new BigDecimal(60));
            statement.setBigDecimal(4,new BigDecimal(61));
            statement.setBigDecimal(5,new BigDecimal(62));
            System.out.println(sql);
            int num= statement.executeUpdate();
            //ResultSet 类似于List<Map<Object
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if(statement!=null)
                    statement.close();
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
执行结果：后面加上了ABC,执行一次加上一次
+------+-----------+---------+------+---------+
| id   | name      | chinese | math | english |
+------+-----------+---------+------+---------+
|    1 | 唐三藏    |    67.0 | 98.0 |    56.0 |
|    2 | 孙悟空    |    87.5 | 78.0 |    77.0 |
|    3 | 猪悟能    |    88.0 | 98.5 |    90.0 |
|    4 | 曹孟德    |    82.0 | 84.0 |    67.0 |
|    5 | 刘玄德    |    55.5 | 85.0 |    45.0 |
|    6 | 孙权      |    70.0 | 73.0 |    78.5 |
|    7 | 宋公明    |    75.0 | 65.0 |    30.0 |
|    1 | ABC       |    60.0 | 61.0 |    62.0 |
|    1 | ABC       |    60.0 | 61.0 |    62.0 |
+------+-----------+---------+------+---------+
*/