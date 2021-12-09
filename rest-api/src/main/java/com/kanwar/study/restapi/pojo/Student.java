package com.kanwar.study.restapi.pojo;

import java.util.Date;

public class Student {
    private int studentId;
    
    private String FristName;
    private String LastName;
    private Date Dob;
    private String Address;
   

    
    public Student(int studentId, String fristName, String lastName, Date dob, String address) {
        this.studentId = studentId;
        FristName = fristName;
        LastName = lastName;
        Dob = dob;
        Address = address;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public String getFristName() {
        return FristName;
    }
    public void setFristName(String fristName) {
        FristName = fristName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public Date getDob() {
        return Dob;
    }
    public void setDob(Date dob) {
        Dob = dob;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    
}
