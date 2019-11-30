package com.bit.model;

import java.util.Date;

public class BorrowInfo {
    private Integer studentId;
    private String studentName;
    private Integer bookId;
    private String bookName;
    private Date startTime;
    private Date endTime;

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
