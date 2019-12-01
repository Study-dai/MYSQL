package com.dai.util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
public class DButil2 {
    private static final String URL="jdbc:mysql://localhost:3306/dai32mall";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    public static void main(String[] args)  {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            //获取数据库连接池，由连接池获取连接
            DataSource ds=new MysqlDataSource();
            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection=ds.getConnection();
            System.out.println(connection);

            String sql="select id,name,chinese,math,english" +
                    " from exam_result where name=?";//注意在IDEA中此处不加分号
            //根据连接创建SQL操作对象statement
            statement=connection.prepareStatement(sql);
             statement.setString(1,"孙悟空");
            System.out.println(sql);
            resultSet=statement.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if(resultSet!=null)
                    resultSet.close();
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
执行结果：
com.mysql.jdbc.JDBC4Connection@5c29bfd
select id,name,chinese,math,english from exam_result where name=?
id=2,name=孙悟空,chinese=87.5,math=78.0,english=77.0

*/