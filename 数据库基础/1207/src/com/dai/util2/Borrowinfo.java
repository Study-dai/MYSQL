package com.dai.util2;

import com.dai.util2.Dbutil;

import java.util.Date;
public class Borrowinfo {
    private Integer studengId;
    private String studentName;
    private Integer bookId;
    private String bookName;
    private Date startTime;
    private Date endTime;

    public Integer getStudengId() {
        return studengId;
    }

    @Override
    public String toString() {
        return "Borrowinfo{" +
                "studengId=" + studengId +
                ", studentName='" + studentName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public void setStudengId(Integer studengId) {
        this.studengId = studengId;
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
