package com.accpedu.model;

public class DepartmentInfoBean {
    private String departmentId;
    private String departmentName;

    public DepartmentInfoBean() {
    }

    public void setDepartmentId(String dId){
        this.departmentId=dId;
    }
    public String getDepartmentId(){
        return this.departmentId;
    }

    public void setDepartmentName(String dName){
        this.departmentName=dName;
    }
    public String getDepartmentName(){
        return this.departmentName;
    }
}
