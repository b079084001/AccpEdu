package com.accpedu.model;

public class ClassInfoBean {
    private String classId;//班级编号
    private String classHQId;//总部班级编号
    private String classTeacher;//授课教员
    private String classManager;//班主任
    private String classBeginDate;//开课日期
    private String classDutoEndDate;//预计结课日期
    private String classTestDate;//预计参加考试时间
    private String classType;//班级种类
    private int classWeekTime;//周课时数
    private int classBeginNumber;//开课人数
    private int classStuIn;//转入
    private int classStuOut;//转出
    private int classStuPause; //休学
    private int classNumber;//班级人数
    private String classEndDate;//结课日期
    private int classEndNumber;//结课时人数
    private double classGraduRate;//预计升学率
    private int classPassNumber;//获证人数
    private int classGradeNumber;//实际升学人数
    private double classRealRate;//实际升学率
    private String classSeme;//学期

    public ClassInfoBean() {
    }

    public void setClassId(String classId){
        this.classId=classId;
    }
    public String getClassId(){
        return this.classId;
    }

    public void setClassHQId(String classHQId){
        this.classHQId=classHQId;
    }
    public String getClassHQId(){
        return this.classHQId;
    }

    public void setClassTeacher(String classTeacher){
        this.classTeacher=classTeacher;
    }
    public String getClassTeacher(){
        return this.classTeacher;
    }

    public void setClassManager(String classManager){
        this.classManager=classManager;
    }
    public String getClassManager(){
        return this.classManager;
    }

    public void setClassBeginDate(String classBeginDate){
        this.classBeginDate=classBeginDate;
    }
    public String getClassBeginDate(){
        return this.classBeginDate;
    }

    public void setClassDutoEndDate(String classDutoEndDate){
        this.classDutoEndDate=classDutoEndDate;
    }
    public String getClassDutoEndDate(){
        return this.classDutoEndDate;
    }

    public void setClassTestDate(String classTestDate){
        this.classTestDate=classTestDate;
    }
    public String getClassTestDate(){
        return this.classTestDate;
    }

    public void setClassType(String classType){
        this.classType=classType;
    }
    public String getClassType(){
        return this.classType;
    }

    public void setClassWeekTime(int classWeekTime){
        this.classWeekTime=classWeekTime;
    }
    public int getClassWeekTime(){
        return this.classWeekTime;
    }

    public void setClassBeginNumber(int classBeginNumberd){
        this.classBeginNumber=classBeginNumber;
    }
    public int getClassBeginNumber(){
        return this.classBeginNumber;
    }

    public void setClassStuIn(int classStuIn){
        this.classStuIn=classStuIn;
    }
    public int getClassStuIn(){
        return this.classStuIn;
    }

    public void setClassStuOut(int classStuOut){
        this.classStuOut=classStuOut;
    }
    public int getClassStuOut(){
        return this.classStuOut;
    }
    public void setClassStuPause(int classStuPause){
        this.classStuPause=classStuPause;
    }
    public int getClassStuPause(){
        return this.classStuPause;
    }

    public void setClassNumber(int classNumber){
        this.classNumber=classNumber;
    }
    public int getClassNumber(){
        return this.classNumber;
    }

    public void setClassEndDate(String classEndDate){
        this.classEndDate=classEndDate;
    }
    public String getClassEndDate(){
        return this.classEndDate;
    }

    public void setClassEndNumber(int classEndNumber){
        this.classEndNumber=classEndNumber;
    }
    public int getClassEndNumber(){
        return this.classEndNumber;
    }

    public void setClassGraduRate(double classGraduRate){
        this.classGraduRate=classGraduRate;
    }
    public double getClassGraduRate(){
        return this.classGraduRate;
    }

    public void setClassPassNumber(int classPassNumber){
        this.classPassNumber=classPassNumber;
    }
    public int getClassPassNumber(){
        return this.classPassNumber;
    }

    public void setClassGradeNumber(int classGradeNumber){
        this.classGradeNumber=classGradeNumber;
    }
    public int getClassGradeNumber(){
        return this.classGradeNumber;
    }

    public void setClassRealRate(double classRealRate){
        this.classRealRate=classRealRate;
    }
    public double getClassRealRate(){
        return this.classRealRate;
    }

    public void setClassSeme(String classSeme){
        this.classSeme=classSeme;
    }
    public String getClassSeme(){
        return this.classSeme;
    }
}
