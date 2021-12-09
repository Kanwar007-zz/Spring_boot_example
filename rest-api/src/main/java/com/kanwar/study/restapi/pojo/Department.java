package com.kanwar.study.restapi.pojo;

public class Department {


   private int departmentId;
   private String departmentName;
   private String block;
   
public Department(int departmentId, String departmentName, String block) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.block = block;
}
public int getDepartmentId() {
    return departmentId;
}
public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
}
public String getDepartmentName() {
    return departmentName;
}
public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
}
public String getBlock() {
    return block;
}
public void setBlock(String block) {
    this.block = block;
}

    
}
