package com.accpedu.model;

public class TimeCheckBean {
    private String stuid;//学号
    private String checkedState="出勤";//出勤状况
    private String checkedDate;//考勤时间

    public TimeCheckBean() {
    }

    public void setStuid(String stuid){
        this.stuid=stuid;
    }
    public String getStuid(){
        return this.stuid;
    }

    public void setCheckedState(String checkedState){
        this.checkedState=checkedState;
    }
    public String getCheckedState(){
        return this.checkedState;
    }

    public void setCheckedDate(String checkedDate){
        this.checkedDate=checkedDate;
    }
    public String getCheckedDate(){
        return this.checkedDate;
    }
}
