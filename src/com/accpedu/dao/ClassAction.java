package com.accpedu.dao;

import com.accpedu.model.ClassInfoBean;
import com.accpedu.util.DBConnection;
import com.accpedu.model.UserInfoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassAction {
    Connection con=null;

    //构造函数，用来加载驱动程序，并和数据库创建连接S
    public ClassAction() {
        if(con==null){
            DBConnection dbcon = new DBConnection();
            con = dbcon.getConnection(); // 和数据库建立连接
        }
    }//end 构造函数

    //在数据库中查询某一班主任所带的所有班级信息
    public ArrayList findAllClass(UserInfoBean user){
        ArrayList list=new ArrayList();

        String teachername="";
        String sqlstr1="select teachername from teacherinfo where teacherid=?";//根据用户的账户查找其姓名
        String sqlstr2="select * from classinfo where classmanager=?";//根据班主任姓名查找其所带班级
        //String sqlstr="select userid from userinfo where userid=? and userpwd=? and userrole=?";

        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=con.prepareStatement(sqlstr1);
            ps.setString(1, user.getUserId());  //设置参数1：用户账号id,也就是教员的编号
            rs=ps.executeQuery();
            if(rs.next()){
                //如果有此班主任
                teachername=rs.getString(1);//根据教员的ID号码查出其姓名
                System.out.println("有这个班主任:"+teachername);
            }
            else{
                System.out.println("没有这个班主任");
            }
            if(!teachername.equals("")){
                ps=con.prepareStatement(sqlstr2);
                ps.setString(1, teachername);  //设置参数1：班主任的姓名
                rs=ps.executeQuery();
                while(rs.next()){
                    //如果此班主任有带课班级
                    System.out.println("此班主任有带课班级");
                    ClassInfoBean classinfo=new ClassInfoBean();
                    //将每个班级信息保存到一个班级对象classinfobean中
                    classinfo.setClassId(rs.getString(1));
                    classinfo.setClassHQId(rs.getString(2));
                    classinfo.setClassTeacher(rs.getString(3));
                    classinfo.setClassManager(rs.getString(4));
                    classinfo.setClassBeginDate(rs.getString(5));
                    classinfo.setClassDutoEndDate(rs.getString(6));
                    classinfo.setClassTestDate(rs.getString(7));
                    classinfo.setClassType(rs.getString(8));
                    classinfo.setClassWeekTime(rs.getInt(9));
                    classinfo.setClassBeginNumber(rs.getInt(10));
                    classinfo.setClassStuIn(rs.getInt(11));
                    classinfo.setClassStuOut(rs.getInt(12));
                    classinfo.setClassStuPause(rs.getInt(13));
                    classinfo.setClassNumber(rs.getInt(14));
                    classinfo.setClassEndDate(rs.getString(15));
                    classinfo.setClassEndNumber(rs.getInt(16));
                    classinfo.setClassGraduRate(rs.getDouble(17));
                    classinfo.setClassPassNumber(rs.getInt(18));
                    classinfo.setClassGradeNumber(rs.getInt(19));
                    classinfo.setClassRealRate(rs.getDouble(20));
                    classinfo.setClassSeme(rs.getString(21));
                    //将查询出来的班级信息存放到一个动态数组当中
                    list.add(classinfo);
                }
            }
        }catch (SQLException ex) {
            System.out.println("查询班级时出错");
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
    }//end method:findAllClass()

    //在数据库中根据班级编号查询某一班级信息
    public ClassInfoBean getClassInfoByClassId(String classid){
        ClassInfoBean classinfo=new ClassInfoBean();
        String sqlstr="select * from classinfo where rtrim(classid)=?";//根据班级编号查找其所带班级

        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=con.prepareStatement(sqlstr);
            ps.setString(1, classid);  //设置参数1：班级编号
            rs=ps.executeQuery();
            if(rs.next()){
                //将班级信息保存到一个班级对象classinfobean中
                    classinfo.setClassId(rs.getString(1));
                    classinfo.setClassHQId(rs.getString(2));
                    classinfo.setClassTeacher(rs.getString(3));
                    classinfo.setClassManager(rs.getString(4));
                    classinfo.setClassBeginDate(rs.getString(5));
                    classinfo.setClassDutoEndDate(rs.getString(6));
                    classinfo.setClassTestDate(rs.getString(7));
                    classinfo.setClassType(rs.getString(8));
                    classinfo.setClassWeekTime(rs.getInt(9));
                    classinfo.setClassBeginNumber(rs.getInt(10));
                    classinfo.setClassStuIn(rs.getInt(11));
                    classinfo.setClassStuOut(rs.getInt(12));
                    classinfo.setClassStuPause(rs.getInt(13));
                    classinfo.setClassNumber(rs.getInt(14));
                    classinfo.setClassEndDate(rs.getString(15));
                    classinfo.setClassEndNumber(rs.getInt(16));
                    classinfo.setClassGraduRate(rs.getDouble(17));
                    classinfo.setClassPassNumber(rs.getInt(18));
                    classinfo.setClassGradeNumber(rs.getInt(19));
                    classinfo.setClassRealRate(rs.getDouble(20));
                    classinfo.setClassSeme(rs.getString(21));
            }
        }catch (SQLException ex) {
            System.out.println("查询班级信息时出错");
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        return classinfo;
    }//end method:getClassInfoByClassId()

    //在数据库中查询某一学期的所有班级信息
    public ArrayList findAllClassBySeme(String seme){
        ArrayList list=new ArrayList();
        String sqlstr="select * from classinfo where rtrim(classseme) like ?";//根据学期查找所有班级
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=con.prepareStatement(sqlstr);
            ps.setString(1, seme);  //设置参数1：学期
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("已经查询出该学期所有的班级");
                ClassInfoBean classinfo=new ClassInfoBean();
                //将每个班级信息保存到一个班级对象classinfobean中
                classinfo.setClassId(rs.getString(1));
                classinfo.setClassHQId(rs.getString(2));
                classinfo.setClassTeacher(rs.getString(3));
                classinfo.setClassManager(rs.getString(4));
                classinfo.setClassBeginDate(rs.getString(5));
                classinfo.setClassDutoEndDate(rs.getString(6));
                classinfo.setClassTestDate(rs.getString(7));
                classinfo.setClassType(rs.getString(8));
                classinfo.setClassWeekTime(rs.getInt(9));
                classinfo.setClassBeginNumber(rs.getInt(10));
                classinfo.setClassStuIn(rs.getInt(11));
                classinfo.setClassStuOut(rs.getInt(12));
                classinfo.setClassStuPause(rs.getInt(13));
                classinfo.setClassNumber(rs.getInt(14));
                classinfo.setClassEndDate(rs.getString(15));
                classinfo.setClassEndNumber(rs.getInt(16));
                classinfo.setClassGraduRate(rs.getDouble(17));
                classinfo.setClassPassNumber(rs.getInt(18));
                classinfo.setClassGradeNumber(rs.getInt(19));
                classinfo.setClassRealRate(rs.getDouble(20));
                classinfo.setClassSeme(rs.getString(21));
                //将查询出来的班级信息存放到一个动态数组当中
                list.add(classinfo);
            }
        }catch (SQLException ex) {
            System.out.println("查询某一学期的班级时出错");
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
    }//end method:findAllClassBySeme()

    //在数据库中增加某一班级的信息
   public int addClass(ClassInfoBean classinfo){
       //设置要执行的sql语句
        String sqlstr1="insert into classinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int line=0;

        try{
            if(con==null){
                DBConnection dbcon = new DBConnection();
                con = dbcon.getConnection(); // 和数据库建立连接
            }
            //插入学生信息表
            ps=con.prepareStatement(sqlstr1);
            ps.setString(1,classinfo.getClassId());
            ps.setString(2,classinfo.getClassHQId());
            ps.setString(3,classinfo.getClassTeacher());
            ps.setString(4,classinfo.getClassManager());
            ps.setString(5,classinfo.getClassBeginDate());
            ps.setString(6,classinfo.getClassDutoEndDate());
            ps.setString(7,classinfo.getClassTestDate());
            ps.setString(8,classinfo.getClassType());
            ps.setInt(9,classinfo.getClassWeekTime());
            ps.setInt(10,classinfo.getClassBeginNumber());
            ps.setInt(11,classinfo.getClassStuIn());
            ps.setInt(12,classinfo.getClassStuOut());
            ps.setInt(13,classinfo.getClassStuPause());
            ps.setInt(14,classinfo.getClassNumber());
            ps.setString(15,classinfo.getClassEndDate());
            ps.setInt(16,classinfo.getClassEndNumber());
            ps.setDouble(17,classinfo.getClassGraduRate());
            ps.setInt(18,classinfo.getClassPassNumber());
            ps.setInt(19,classinfo.getClassGradeNumber());
            ps.setDouble(20,classinfo.getClassRealRate());
            ps.setString(21,classinfo.getClassSeme());

            line=ps.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("插入学员信息时出错");
            ex.printStackTrace();
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
   }//end method:addClass()

    //在数据库中删除某一班级的信息
    public int deleteClass(String classno){
        //设置要执行的sql语句
        String sqlstr="delete from classinfo where rtrim(classid)=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int line=0;

        try{
            if(con==null){
                DBConnection dbcon = new DBConnection();
                con = dbcon.getConnection(); // 和数据库建立连接
            }

            ps=con.prepareStatement(sqlstr);
            ps.setString(1,classno);  //设置参数1：班级编号

            line=ps.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("删除班级信息时出错");
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
    }//end method:deleteClass()

}
