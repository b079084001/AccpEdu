package com.accpedu.view;

import com.accpedu.dao.SubjectAction;
import com.accpedu.util.DBConnection;
import com.accpedu.model.ClassInfoBean;
import com.accpedu.model.SubjectBean;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.sql.*;
import java.util.ArrayList;

public class TableFactory {
    ClassInfoBean classinfo=null;
    int selected=1;
    String classid=null;

    SubjectAction subjectAction=null;
    ArrayList subjectList=null;
    SubjectBean subjectBean=null;

    public TableFactory(ClassInfoBean classinfo, int selected) {
        this.classinfo=classinfo;
        this.selected=selected;
        classid=classinfo.getClassId();

        subjectAction=new SubjectAction();
        subjectList=subjectAction.getAllSubjectInfo(this.classinfo.getClassSeme());
        subjectBean=(SubjectBean)subjectList.get(selected-1);
    }

    public DefaultTableModel getTableModel(){
        Connection con=null;
       //设置要执行的sql语句
       String sqlstr="select studentinfo.stuid,studentinfo.stuname,?,scoreinfo.score "+
                     "from studentinfo,scoreinfo "+
                     "where studentinfo.stuclassid=? and studentinfo.stuid=scoreinfo.stuid "+
                     "and scoreinfo.subjectno=?";
       PreparedStatement ps=null;
       ResultSet rs=null;
       ResultSetMetaData rsmd = null;
       DefaultTableModel defaultTableModel=null;

       try{
           if(con==null){
               DBConnection dbcon = new DBConnection();
               con = dbcon.getConnection(); // 和数据库建立连接
           }

           ps=con.prepareStatement(sqlstr);
           ps.setString(1,subjectBean.getSubjectName());  //设置参数1：科目名称
           ps.setString(2,classid);
           ps.setString(3,subjectBean.getSubjectNo());

           rs=ps.executeQuery();

           defaultTableModel=new DefaultTableModel();
           rsmd = rs.getMetaData();

           defaultTableModel.setColumnCount(0);
           defaultTableModel.setRowCount(0);
           //添加表头
           defaultTableModel.addColumn("学号");
           defaultTableModel.addColumn("姓名");
           defaultTableModel.addColumn("科目");
           defaultTableModel.addColumn("成绩");

           int i = 0;
           while (rs.next()) {
               defaultTableModel.setNumRows(i + 1);
               for (int j = 0; j < rsmd.getColumnCount(); j++) {
                   defaultTableModel.setValueAt(rs.getString(j + 1), i, j);
               }
               i++;
           }
       }catch (SQLException ex) {
           System.out.println("创建成绩表时出错");
       }finally{  //关闭数据库连接对象
           try{
               if(rs!=null)    rs.close();
               if(ps!=null)    ps.close();
               if(con!=null)   con.close();
           }catch(SQLException ex){
               //do nothing
           }
       }
       return defaultTableModel;
    }

    //
    public DefaultTableModel getTableModelByStuNo(String stuNo){
        Connection con=null;
       //设置要执行的sql语句
       String sqlstr="select scoreinfo.stuid,studentinfo.stuname,subjectinfo.subjectname,scoreinfo.score "+
                     "from studentinfo,subjectinfo,scoreinfo "+
                     "where scoreinfo.stuid=? and studentinfo.stuid=? "+
                     "and scoreinfo.subjectno=subjectinfo.subjectno "+
                     "and subjectinfo.subjectseme=?";
       PreparedStatement ps=null;
       ResultSet rs=null;
       ResultSetMetaData rsmd = null;
       DefaultTableModel defaultTableModel=null;

       try{
           if(con==null){
               DBConnection dbcon = new DBConnection();
               con = dbcon.getConnection(); // 和数据库建立连接
           }

           ps=con.prepareStatement(sqlstr);
           ps.setString(1,stuNo);  //设置参数1：科目名称
           ps.setString(2,stuNo);
           ps.setString(3,this.classinfo.getClassSeme());

           rs=ps.executeQuery();

           defaultTableModel=new DefaultTableModel();
           rsmd = rs.getMetaData();

           defaultTableModel.setColumnCount(0);
           defaultTableModel.setRowCount(0);
           //添加表头
           defaultTableModel.addColumn("学号");
           defaultTableModel.addColumn("姓名");
           defaultTableModel.addColumn("科目");
           defaultTableModel.addColumn("成绩");

           int i = 0;
           while (rs.next()) {
               defaultTableModel.setNumRows(i + 1);
               for (int j = 0; j < rsmd.getColumnCount(); j++) {
                   defaultTableModel.setValueAt(rs.getString(j + 1), i, j);
               }
               i++;
           }
       }catch (SQLException ex) {
           System.out.println("查询成绩表时出错");
       }finally{  //关闭数据库连接对象
           try{
               if(rs!=null)    rs.close();
               if(ps!=null)    ps.close();
               if(con!=null)   con.close();
           }catch(SQLException ex){
               //do nothing
           }
       }
       return defaultTableModel;
    }//end getTableModelByStuNo()

    public DefaultTableModel getTableModelByTimeCheckDate(String timeCheckDate){
        Connection con=null;
       //设置要执行的sql语句
       String sqlstr="select timecheckinfo.stuid,studentinfo.stuname,timecheckinfo.checkedstate,timecheckinfo.checkedtime "+
                     "from studentinfo,timecheckinfo "+
                     "where rtrim(studentinfo.stuclassid)=? and rtrim(timecheckinfo.stuid)=rtrim(studentinfo.stuid) "+
                     "and timecheckinfo.checkedtime=?";
       PreparedStatement ps=null;
       ResultSet rs=null;
       ResultSetMetaData rsmd = null;
       DefaultTableModel defaultTableModel=null;

       try{
           if(con==null){
               DBConnection dbcon = new DBConnection();
               con = dbcon.getConnection(); // 和数据库建立连接
           }

           ps=con.prepareStatement(sqlstr);
           ps.setString(1,classinfo.getClassId());  //设置参数1：考勤班级
           ps.setString(2,timeCheckDate); //设置参数2：考勤时间

           rs=ps.executeQuery();

           defaultTableModel=new DefaultTableModel();
           rsmd = rs.getMetaData();

           defaultTableModel.setColumnCount(0);
           defaultTableModel.setRowCount(0);
           //添加表头
           defaultTableModel.addColumn("学号");
           defaultTableModel.addColumn("姓名");
           defaultTableModel.addColumn("出勤状况");
           defaultTableModel.addColumn("考勤日期");

           int i = 0;
           while (rs.next()) {
               defaultTableModel.setNumRows(i + 1);
               for (int j = 0; j < rsmd.getColumnCount(); j++) {
                   defaultTableModel.setValueAt(rs.getString(j + 1), i, j);
               }
               i++;
           }
       }catch (SQLException ex) {
           System.out.println("查询成绩表时出错");
       }finally{  //关闭数据库连接对象
           try{
               if(rs!=null)    rs.close();
               if(ps!=null)    ps.close();
               if(con!=null)   con.close();
           }catch(SQLException ex){
               //do nothing
           }
       }
       return defaultTableModel;
    }//end getTableModelByStuNo()

    //
    public DefaultTableModel getTableModelByStuid(String stuid){
       //设置要执行的sql语句
       String sqlstr="select timecheckinfo.stuid,studentinfo.stuname,timecheckinfo.checkedstate,timecheckinfo.checkedtime "+
                     "from studentinfo,timecheckinfo "+
                     "where rtrim(timecheckinfo.stuid)=? and rtrim(studentinfo.stuid)=?";
       DBConnection dbcon = new DBConnection();
       Connection con = dbcon.getConnection(); // 和数据库建立连接

       PreparedStatement ps=null;
       ResultSet rs=null;
       ResultSetMetaData rsmd = null;
       DefaultTableModel defaultTableModel=new DefaultTableModel();
       try{
           ps=con.prepareStatement(sqlstr);
           ps.setString(1,stuid);  //设置参数1：学员学号
           ps.setString(2,stuid);  //设置参数2：学员学号
           rs=ps.executeQuery();
           rsmd = rs.getMetaData();

           defaultTableModel.setColumnCount(0);
           defaultTableModel.setRowCount(0);
           //添加表头
           defaultTableModel.addColumn("学号");
           defaultTableModel.addColumn("姓名");
           defaultTableModel.addColumn("出勤状况");
           defaultTableModel.addColumn("考勤日期");

           int i = 0;
           while (rs.next()) {
               defaultTableModel.setNumRows(i + 1);
               for (int j = 0; j < rsmd.getColumnCount(); j++) {
                   defaultTableModel.setValueAt(rs.getString(j + 1), i, j);
               }
               i++;
           }
       }catch (SQLException ex) {
           System.out.println("根据学号查询时出错");
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
       return defaultTableModel;
    }//end getTableModelByStuid
}
