package com.dai.util2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class BorrowServerice {
    public static  List<Borrowinfo> queryByBookName(String name){
        //获取连接
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Borrowinfo> infos=new ArrayList<>();
        try {
            connection=Dbutil.getConnection();
            String sql="select stu.id,stu.name,bi.end_time" +
                    " from borrow_info bi" +
                    " join student stu on bi.student_id = stu.id" +
                    " join book b on bi.book_id = b.id" +
                    " where b.name=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            while(rs.next()){
                Borrowinfo info=new Borrowinfo();
                info.setBookId(rs.getInt("book_id"));
                info.setStudentName( rs.getString("student_name"));
                info.setBookId(rs.getInt("student_id"));
                info.setBookName(rs.getString("book_name"));
                info.setStartTime(rs.getTimestamp("start_time"));
                info.setEndTime(rs.getTimestamp("end_time"));
                infos.add(info);
            }
        }catch (Exception e){

        }finally {
            Dbutil.close(connection,ps,rs);
        }
        return infos;
    }
    public static void main(String[] args) {
        System.out.println(queryByBookName("史记"));
    }
}
