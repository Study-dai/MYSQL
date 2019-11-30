package com.bit.service;

import com.bit.model.BorrowInfo;
import com.bit.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowService {

    public static List<BorrowInfo> queryByBookName(String name){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BorrowInfo> infos = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select stu.id student_id,stu.name student_name,b.id book_id," +
                    "b.name book_name,bi.start_time,bi.end_time" +
                    " from borrow_info bi" +
                    "    join student stu on bi.student_id=stu.id" +
                    "    join book b on bi.book_id=b.id" +
                    " where b.name=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()){
                BorrowInfo info = new BorrowInfo();
                info.setStudentId(rs
                        .getInt("student_id"));
                info.setStudentName(rs
                        .getString("student_name"));
                info.setBookId(rs
                        .getInt("book_id"));
                info.setBookName(rs
                        .getString("book_name"));
                info.setStartTime(rs
                        .getTimestamp("start_time"));
                info.setEndTime(rs
                        .getTimestamp("end_time"));
                infos.add(info);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, ps, rs);
        }
        return infos;
    }

    public static void main(String[] args) {
        System.out.println(queryByBookName("史记"));
    }
}
