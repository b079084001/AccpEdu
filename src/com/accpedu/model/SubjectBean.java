package com.accpedu.model;

public class SubjectBean {
    private String subjectNo;//科目编号
    private String subjectName;//科目名称
    private String subjectSeme;//所属学期

    public SubjectBean() {
    }

    public void setSubjectNo(String subjectNo){
        this.subjectNo=subjectNo;
    }
    public String getSubjectNo(){
        return this.subjectNo;
    }

    public void setSubjectName(String subjectName){
        this.subjectName=subjectName;
    }
    public String getSubjectName(){
        return this.subjectName;
    }

    public void setSubjectSeme(String subjectSeme){
        this.subjectSeme=subjectSeme;
    }
    public String getSubjectSeme(){
        return this.subjectSeme;
    }

}
