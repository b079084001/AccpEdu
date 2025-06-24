package com.accpedu.dao;

import com.accpedu.util.DBConnection;
import com.accpedu.model.DepartmentInfoBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;

public class DepartmentAction {
    public DepartmentAction() {
    }
    //在数据库中查询所有部门信息
    public ArrayList findAllDepartments(){
        ArrayList list=new ArrayList();

        String sqlstr="select * from departmentinfo";

        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getConnection(); // 和数据库建立连接
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=con.prepareStatement(sqlstr);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("已经查找到所有部门");
                DepartmentInfoBean departmentinfo=new DepartmentInfoBean();
                //将每个班级信息保存到一个班级对象departmentinfo中
                departmentinfo.setDepartmentId(rs.getString(1));
                departmentinfo.setDepartmentName(rs.getString(2));
                //将查询出来的班级信息存放到一个动态数组当中
                list.add(departmentinfo);
            }
        }catch (SQLException ex) {
            System.out.println("查询部门时出错");
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
    }//end method:findAllDepartments()

}
