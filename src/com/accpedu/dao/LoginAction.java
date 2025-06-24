package com.accpedu.dao;

import com.accpedu.model.UserInfoBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAction {
    Connection con=null;

    //构造函数，用来加载驱动程序，并和数据库创建连接S
    public LoginAction() {
        try{
            System.out.println("正在加载驱动程序......");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动程序成功");
        }catch(ClassNotFoundException e){
            System.out.println("加载驱动程序失败");
        }//end try-catch
    }//end 构造函数

    // 和数据库建立连接
    public Connection getConnection(){
        Connection con=null;
//        String url="jdbc:mysql://localhost:3306/accp?useUnicode=true&characterEncoding=GBK";
        String url="jdbc:mysql://localhost:3306/accp?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2b8&allowPublicKeyRetrieval=true";
        String user="root";
        String password="123456";
        try{
            System.out.println("正在和数据库建立连接......");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accp?useUnicode=true&characterEncoding=GBK","","");
            //String url="jdbc:mysql://localhost:3306/accp?useUnicode=true&characterEncoding=GBK";
            con=DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功");
        }catch(SQLException e){
            System.out.println("无法和数据库建立连接");
        }//end try-catch
        return con;
    }
    //在数据库中验证用户合法性
    public UserInfoBean verify(UserInfoBean user){
        PreparedStatement ps=null;
        ResultSet rs=null;
        if(con==null){
            con=this.getConnection();
        }

        UserInfoBean newUser=null;
        String sqlstr="select * from userinfo where userid=? and userpwd=? and userrole like ?";

        try{
            ps=con.prepareStatement(sqlstr);
            ps.setString(1, user.getUserId());  //设置参数1：用户账号id
            ps.setString(2, user.getUserPwd()); //设置参数2：用户密码
            ps.setString(3,user.getRoleId());   //设置参数3：角色id
            rs=ps.executeQuery();
            if(rs.next()){
                //如果用户提供的账号、密码和角色正确
                System.out.println("有这个用户");
                newUser=user;
                newUser.setUserNo(rs.getInt(1));
                //newUser.setIfFirst(rs.getString(4));
            }
        }catch (SQLException ex) {
            System.out.println("验证用户合法性时出错");
        }finally{  //关闭数据库连接对象
            try{
                if(rs!=null)    rs.close();
                if(ps!=null)    ps.close();
                if(con!=null)   con.close();
            }catch(SQLException ex){
                //do nothing
            }
        }
        return newUser;
    }//end method:verify()
/*
    //判断用户是否为第一次登录
    public boolean isFirst(UserInfoBean user){
        PreparedStatement ps=null;
        ResultSet rs=null;
        if(con==null){
            con=this.getConnection();
        }

        boolean flag=false;
        String sqlstr="select isfirst from userinfo where userid=? and userpwd=? and userrole=?";

        try{
            ps=con.prepareStatement(sqlstr);
            ps.setString(1, user.getUserId());  //设置参数1：用户账号id
            ps.setString(2, user.getUserPwd()); //设置参数2：用户密码
            ps.setString(3,user.getRoleId());   //设置参数3：角色id
            rs=ps.executeQuery();
            if(rs.next()){
                flag=true;      //如果用户提供的账号、密码和角色正确
            }
        }catch (SQLException ex) {
            System.out.println("验证用户是否第一\uFFFD\uFFFD登录时出错");
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
*/
}
