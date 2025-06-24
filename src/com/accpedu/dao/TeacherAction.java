package com.accpedu.dao;

import com.accpedu.util.DBConnection;
import com.accpedu.model.TeacherInfoBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;

public class TeacherAction {
    public TeacherAction() {
    }

    //在数据库中查询某部门已经是用户的员工信息
    public ArrayList findUserTeachersByDepart(String department){
        ArrayList list=new ArrayList();

        String sqlstr="select * from teacherinfo where rtrim(teacherdepartment) like ? "+
                      "and rtrim(teacherid) in ("+
                      "select userid from userinfo)";

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=con.prepareStatement(sqlstr);
            ps.setString(1,department);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("已经查找到此部门的所有已经是用户的员工信息");
                TeacherInfoBean teacherinfo=new TeacherInfoBean();
                //将每个员工信息保存到一个教员对象teacherinfo中
                teacherinfo.setTeacherId(rs.getString(1));
                teacherinfo.setTeacherName(rs.getString(2));
                teacherinfo.setTeacherBirthday(rs.getString(3));
                teacherinfo.setTeacherSex(rs.getString(4));
                teacherinfo.setTeacherSchool(rs.getString(5));
                teacherinfo.setTeacherTech(rs.getString(6));
                teacherinfo.setTeacherAddress(rs.getString(7));
                teacherinfo.setTeacherInDate(rs.getString(8));
                teacherinfo.setTeacherDepartment(rs.getString(9));
                teacherinfo.setTeacherDuty(rs.getString(10));
                //将查询出来的班级信息存放到一个动态数组当中
                list.add(teacherinfo);
            }
        }catch (SQLException ex) {
            System.out.println("查询教员信息时出错2");
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        return list;
    }//end method:findUserTeachersByDepart()

    //在数据库中查询某部门非用户的员工信息
    public ArrayList findNonUserTeachersByDepart(String department){
        ArrayList list=new ArrayList();

        String sqlstr="select * from teacherinfo where rtrim(teacherdepartment) like ? "+
                      "and rtrim(teacherid) not in ("+
                      "select userid from userinfo)";

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=con.prepareStatement(sqlstr);
            ps.setString(1,department);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("已经查找到此部门的所有非用户的员工信息");
                TeacherInfoBean teacherinfo=new TeacherInfoBean();
                //将每个员工信息保存到一个教员对象teacherinfo中
                teacherinfo.setTeacherId(rs.getString(1));
                teacherinfo.setTeacherName(rs.getString(2));
                teacherinfo.setTeacherBirthday(rs.getString(3));
                teacherinfo.setTeacherSex(rs.getString(4));
                teacherinfo.setTeacherSchool(rs.getString(5));
                teacherinfo.setTeacherTech(rs.getString(6));
                teacherinfo.setTeacherAddress(rs.getString(7));
                teacherinfo.setTeacherInDate(rs.getString(8));
                teacherinfo.setTeacherDepartment(rs.getString(9));
                teacherinfo.setTeacherDuty(rs.getString(10));
                //将查询出来的班级信息存放到一个动态数组当中
                list.add(teacherinfo);
            }
        }catch (SQLException ex) {
            System.out.println("查询教员信息时出错2");
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        return list;
    }//end method:findNonUserTeachersByDepart()

    //在数据库中查询某部门员工信息
    public ArrayList findTeachersByDepart(String department){
        ArrayList list=new ArrayList();

        String sqlstr="select * from teacherinfo where rtrim(teacherdepartment) like ?";

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=con.prepareStatement(sqlstr);
            ps.setString(1,department);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("已经查找到此部门的所有员工信息");
                TeacherInfoBean teacherinfo=new TeacherInfoBean();
                //将每个员工信息保存到一个教员对象teacherinfo中
                teacherinfo.setTeacherId(rs.getString(1));
                teacherinfo.setTeacherName(rs.getString(2));
                teacherinfo.setTeacherBirthday(rs.getString(3));
                teacherinfo.setTeacherSex(rs.getString(4));
                teacherinfo.setTeacherSchool(rs.getString(5));
                teacherinfo.setTeacherTech(rs.getString(6));
                teacherinfo.setTeacherAddress(rs.getString(7));
                teacherinfo.setTeacherInDate(rs.getString(8));
                teacherinfo.setTeacherDepartment(rs.getString(9));
                teacherinfo.setTeacherDuty(rs.getString(10));
                //将查询出来的班级信息存放到一个动态数组当中
                list.add(teacherinfo);
            }
        }catch (SQLException ex) {
            System.out.println("查询教员信息时出错");
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        return list;
    }//end method:findTeachersByDepart()

    //在数据库中增加某一员工信息
    public int addTeacher(TeacherInfoBean teacherinfo){
        String sqlstr = "insert into teacherinfo values(?,?,?,?,?,?,?,?,?,?)";
        int result = 0;

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sqlstr);
            ps.setString(1, teacherinfo.getTeacherId());
            ps.setString(2, teacherinfo.getTeacherName());
            ps.setString(3, teacherinfo.getTeacherBirthday());
            ps.setString(4, teacherinfo.getTeacherSex());
            ps.setString(5, teacherinfo.getTeacherSchool());
            ps.setString(6, teacherinfo.getTeacherTech());
            ps.setString(7, teacherinfo.getTeacherAddress());
            ps.setString(8, teacherinfo.getTeacherInDate());
            ps.setString(9, teacherinfo.getTeacherDepartment());
            ps.setString(10, teacherinfo.getTeacherDuty());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("增加教员信息时出错");
        } finally { //关闭数据库连接对象
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                //do nothing
            }
        }
        return result;
    }//end addTeacher()

    //在数据库中删除某一员工信息
    public int delTeacher(String teacherid){
        String sqlstr = "delete from teacherinfo where rtrim(teacherid)=?";
        int result = 0;

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sqlstr);
            ps.setString(1, teacherid);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("删除教员信息时出错");
        } finally { //关闭数据库连接对象
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                //do nothing
            }
        }
        return result;
    }//end delTeacher()
}
