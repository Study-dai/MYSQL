package com.dai.util;
import java.math.BigDecimal;
import java.sql.*;
/*JDBC使用步骤
1、创建数据库连接Connection
2、创建操作名Statement
3、使用操作命令来执行SQL
4、处理结果集ResultSet
5、释放资源
*/
public class DButil {
    //数据库连接URl地址
    private static final String URL="jdbc:mysql://localhost:3306/dai32mall";
    //数据库账号
    private static final String USERNAME="root";
    //数据库密码
    private static final String PASSWORD="root";
    public static void main(String[] args)  {
        Connection connection=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据连接
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println(connection);
            //根据连接创建SQL操作对象Statement
            Statement statement=connection.createStatement();
            String sql="select id,name,chinese,math,english from exam_result";//注意在IDEA中此处不加分号
            ResultSet resultSet=statement.executeQuery(sql);
            //ResultSet 类似于List<Map<Object
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                BigDecimal chinese= resultSet.getBigDecimal("chinese");
                 BigDecimal math= resultSet.getBigDecimal("math");
                BigDecimal english= resultSet.getBigDecimal("english");
                System.out.printf("id=%s,name=%s,chinese=%s,math=%s,english=%s",
                        id,name,chinese,math,english);
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if(connection!=null)
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
/*执行结果
Sun Dec 01 12:42:26 CST 2019 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.jdbc.JDBC4Connection@4b85612c
id=1,name=唐三藏,chinese=67.0,math=98.0,english=56.0
id=2,name=孙悟空,chinese=87.5,math=78.0,english=77.0
id=3,name=猪悟能,chinese=88.0,math=98.5,english=90.0
id=4,name=曹孟德,chinese=82.0,math=84.0,english=67.0
id=5,name=刘玄德,chinese=55.5,math=85.0,english=45.0
id=6,name=孙权,chinese=70.0,math=73.0,english=78.5
id=7,name=宋公明,chinese=75.0,math=65.0,english=30.0
Process finished with exit code 0
*/