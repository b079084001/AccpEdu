package com.accpedu.dao;

import com.accpedu.util.DBConnection;
import com.accpedu.model.TimeCheckBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;

public class TimeCheckAction {
    //构造函数，用来加载驱动程序，并和数据库创建连接S
    public TimeCheckAction() {
    }

    //检查是否有重复的考勤日期
    public boolean checkTimeCheckDate(String checkDate){
        boolean flag=true;

        String sqlstr1="select * from timecheckinfo where checkedtime=?";//根据考勤时间查找

        PreparedStatement ps=null;
        ResultSet rs=null;
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        try{
            ps=con.prepareStatement(sqlstr1);
            ps.setString(1, checkDate);  //设置参数1：考勤时间
            rs=ps.executeQuery();
            if(rs.next()){
                //如果有此日期考勤
                flag=false;
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
        return flag;
    }

    //初始化考勤记录
    public void addNewTimeCheck(ArrayList list){
        String sqlstr1="insert into timecheckinfo(stuid,checkedtime) values(?,?)";
        PreparedStatement ps=null;
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        System.out.println("con1="+con);
        try{
                System.out.println("con2=" + con);
                ps = con.prepareStatement(sqlstr1);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    TimeCheckBean timeCheckBean = (TimeCheckBean) it.next();
                    ps.setString(1, timeCheckBean.getStuid()); //设置参数1：学员学号
                    ps.setString(2, timeCheckBean.getCheckedDate()); //设置参数2：考勤时间
                    ps.executeUpdate();
                }
        }catch (SQLException ex) {
            System.out.println("初始化考勤记录时出错");
            ex.printStackTrace();
        }finally{  //关闭数据库连接对象
            try{
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }//end finally
    }//end addNewTimeCheck

    //更新考勤信息
    public void updateTimeCheck(TimeCheckBean timeCheckBean){
        String sqlstr1="update timecheckinfo set checkedstate=? "+
                       "where stuid=? and checkedtime=?";

        PreparedStatement ps=null;
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        try{
            ps=con.prepareStatement(sqlstr1);
            ps.setString(1,timeCheckBean.getCheckedState());
            ps.setString(2,timeCheckBean.getStuid());
            ps.setString(3,timeCheckBean.getCheckedDate());
            System.out.println(timeCheckBean.getCheckedDate());
            ps.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("设置考勤记录时出错");
        }finally{  //关闭数据库连接对象
            try{
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }//end finally
    }//end addNewTimeCheck

    //获取某班所有考勤时间
    public ArrayList getCheckTime(String classid){
        String sqlstr1="select distinct checkedtime  "+
                       "from timecheckinfo "+
                       "where stuid in("+
                       "select stuid from studentinfo where rtrim(stuclassid)=?)";

        ArrayList list=new ArrayList();
        PreparedStatement ps=null;
        ResultSet rs=null;
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        try{
            ps=con.prepareStatement(sqlstr1);
            ps.setString(1,classid);
            System.out.println("classid2="+classid);
            rs=ps.executeQuery();
            while(rs.next()){
                String a=rs.getString(1);
                System.out.println("a="+a);
                list.add(a);
                //list.add(rs.getString(1));
            }
        }catch (SQLException ex) {
            System.out.println("获取考勤日期时出错");
            ex.printStackTrace();
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }//end finally
        return list;
    }//end addNewTimeCheck
}
