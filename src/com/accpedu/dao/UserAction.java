package com.accpedu.dao;

import com.accpedu.util.DBConnection;
import com.accpedu.model.UserBean;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserAction {
    public UserAction() {
    }

    //在数据库中增加某一用户信息
    public int addUser(String userid){
        String sqlstr = "insert into userinfo(userid,userpwd,userrole) values(?,?)";
        int result = 0;

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sqlstr);
            ps.setString(1, userid);
            ps.setString(2, "111111");
            ps.setString(3, "");
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("增加用户信息时出错");
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
    }//end addUser()

    //在数据库中删除某一用户信息
    public int delUser(String userid){
        String sqlstr = "delete from userinfo  where rtrim(userid)=?";
        int result = 0;

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sqlstr);
            ps.setString(1, userid);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("删除用户信息时出错");
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
    }//end delUser()

    //在数据库中查找某一用户信息
    public UserBean getUser(String userid){
        String sqlstr = "select * from userinfo where rtrim(userid)=?";
        UserBean userInfo=new UserBean();

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            ps = con.prepareStatement(sqlstr);
            ps.setString(1, userid);
            rs = ps.executeQuery();
            if(rs.next()){
                userInfo.setUserNo(rs.getInt(1));
                userInfo.setUserId(rs.getString(2));
                userInfo.setUserPwd(rs.getString(3));
                userInfo.setUserRole(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("查找用户信息时出错");
        } finally { //关闭数据库连接对象
            try {
                if(rs!=null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                //do nothing
            }
        }
        return userInfo;
    }//end getUser()

    //在数据库中修改某一用户权限
    public int updateUserRole(String userid,String role){
        String sqlstr = "update userinfo set userrole=? where rtrim(userid)=?";
        int result = 0;

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sqlstr);
            ps.setString(1,role);
            ps.setString(2, userid);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("更新用户权限时出错");
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
    }//end updateUserRole()

    //在数据库中修改某一用户密码
    public int updateUserPwd(String userid,String userpwd){
        String sqlstr = "update userinfo set userpwd=? where rtrim(userid)=?";
        int result = 0;

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sqlstr);
            ps.setString(1,userpwd);
            ps.setString(2, userid);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("更改用户密码时出错");
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
    }//end updateUserPwd()

}
