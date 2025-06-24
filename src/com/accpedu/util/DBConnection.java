package com.accpedu.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    Connection con=null;

    //构造函数，用来加载驱动程序，并和数据库创建连接S
    public DBConnection() {
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
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accp?useUnicode=true&characterEncoding=GBK","","");
//            String url="jdbc:mysql://localhost:3306/accp?useUnicode=true&characterEncoding=GBK";
            con=DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功");
        }catch(SQLException e){
            System.out.println("无法和数据库建立连接");
        }//end try-catch
        return con;
    }
}
