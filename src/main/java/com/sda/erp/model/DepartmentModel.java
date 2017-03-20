package com.sda.erp.model;

/* Created by Artur Rózgowski on 3/19/17 */
public class DepartmentModel {

    private int departmentNo;
    private String departmentName;

    public DepartmentModel () {}

    public DepartmentModel (int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
    }

    public DepartmentModel(int departmentNo) {
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
