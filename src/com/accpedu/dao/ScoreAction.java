package com.accpedu.dao;

import com.accpedu.util.DBConnection;
import com.accpedu.model.ScoreBean;
import com.accpedu.model.SubjectBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Iterator;

public class ScoreAction {
    Connection con=null;

    public ScoreAction() {
    }

    //学员入班，增加一个学员信息
    public void addStudentScore(String stuNo,ArrayList subjectList){
        //设置要执行的sql语句
        String sqlstr1="insert into scoreinfo values(?,?,?)";//插入成绩表：学号，科目，成绩
        PreparedStatement ps=null;
        //ResultSet rs=null;
        //int line=0;

        try{
            if(con==null){
                DBConnection dbcon = new DBConnection();
                con = dbcon.getConnection(); // 和数据库建立连接
            }
            //插入学生信息表
            ps=con.prepareStatement(sqlstr1);
            Iterator it=subjectList.iterator();
            while(it.hasNext()){
                ps.setString(1, stuNo);
                ps.setString(2, ((SubjectBean)it.next()).getSubjectNo());
                ps.setInt(3, 0);
                ps.executeUpdate();
            }
        }catch (SQLException ex) {
            System.out.println("向成绩表中插入学员信息时出错");
            ex.printStackTrace();
        }finally{  //关闭数据库连接对象
            try{
                //if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        //return line;
    }//end method:addStudent()

    //在数据库中查询某一班主任所带的某一班级的学员信息
    public int deleteStudentScore(String stuno){
        //设置要执行的sql语句
        String sqlstr="delete from scoreinfo where rtrim(stuid)=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int line=0;

        try{
            if(con==null){
                DBConnection dbcon = new DBConnection();
                con = dbcon.getConnection(); // 和数据库建立连接
            }

            ps=con.prepareStatement(sqlstr);
            ps.setString(1,stuno);  //设置参数1：学号

            line=ps.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("在成绩表中删除学员信息时出错");
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        return line;
    }//end method:deleteStudent()

    //在数据库中查询某一班主任所带的某一班级的学员信息
    public int updateStudentScore(ScoreBean scoreBean){
        //设置要执行的sql语句
        String sqlstr="update scoreinfo set score=? where rtrim(stuid)=? and rtrim(subjectno)=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int line=0;

        try{
            if(con==null){
                DBConnection dbcon = new DBConnection();
                con = dbcon.getConnection(); // 和数据库建立连接
            }

            ps=con.prepareStatement(sqlstr);
            ps.setInt(1,scoreBean.getScore());  //设置参数1：成绩
            ps.setString(2,scoreBean.getStuNo());
            ps.setString(3,scoreBean.getSubjectNo());

            line=ps.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("在成绩表中删除学员信息时出错");
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        return line;
    }//end method:updateStudentScore()

}
