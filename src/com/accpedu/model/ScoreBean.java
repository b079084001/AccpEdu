package com.accpedu.model;

public class ScoreBean {
    private String stuNo;//学生学号
    private String subjectNo;//科目编号
    private int score;//成绩

    public ScoreBean() {
    }

    public void setStuNo(String stuNo){
        this.stuNo=stuNo;
    }
    public String getStuNo(){
        return this.stuNo;
    }

    public void setSubjectNo(String subjectNo){
        this.subjectNo=subjectNo;
    }
    public String getSubjectNo(){
        return this.subjectNo;
    }

    public void setScore(int score){
        this.score=score;
    }
    public int getScore(){
        return this.score;
    }
}
