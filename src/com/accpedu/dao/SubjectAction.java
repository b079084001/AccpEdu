package com.accpedu.dao;

import com.accpedu.util.DBConnection;
import com.accpedu.model.SubjectBean;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubjectAction {
    Connection con=null;

    public SubjectAction() {
    }

    //在数据库中查询某一班主任所带的某一班级的学员信息
    public ArrayList getAllSubjectInfo(String subjectSeme){
        ArrayList list=new ArrayList();
        String sqlstr="select * from subjectinfo where subjectSeme=?";//根据所在班级编号查询该班所有学生
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            if(con==null){
                DBConnection dbcon = new DBConnection();
                con = dbcon.getConnection(); // 和数据库建立连接
            }

            ps=con.prepareStatement(sqlstr);
            ps.setString(1,subjectSeme);  //设置参数1：学期
            rs=ps.executeQuery();
            while(rs.next()){
                    SubjectBean subjectBean=new SubjectBean();
                    //将每个科目信息保存到一个科目对象subjectBean中
                    subjectBean.setSubjectNo(rs.getString(1));
                    subjectBean.setSubjectName(rs.getString(2));
                    subjectBean.setSubjectSeme(rs.getString(3));
                    //将查询出来的科目信息存放到一个动态数组当中
                    list.add(subjectBean);
            }//end while
        }catch (SQLException ex) {
            System.out.println("查询科目信息时出错");
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
    }//end method:findStudentsByClassId()

}
