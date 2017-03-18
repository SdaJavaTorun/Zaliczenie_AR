package com.sda.erp.model;

/* Created by Artur Rózgowski on 3/18/17 */
public class Department {

    private int departmentNo;
    private String departmentName;

    public Department(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
    }

    public Department(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
