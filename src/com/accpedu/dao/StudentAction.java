package com.accpedu.dao;

import com.accpedu.util.DBConnection;
import com.accpedu.model.StuInfoBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;

public class StudentAction {
    Connection con=null;

    //构造函数，用来加载驱动程序，并和数据库创建连接S
    public StudentAction() {
        if(con==null){
            DBConnection dbcon = new DBConnection();
            con = dbcon.getConnection(); // 和数据库建立连接
        }
    }//end 构造函数

    //在数据库中查询某一班主任所带的某一班级的学员信息
    public ArrayList findStudentsByClassId(String classid){
        ArrayList list=new ArrayList();
        String sqlstr="select * from studentinfo where stuclassid=?";//根据所在班级编号查询该班所有学生
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            if(con==null){
                DBConnection dbcon = new DBConnection();
                con = dbcon.getConnection(); // 和数据库建立连接
            }

            ps=con.prepareStatement(sqlstr);
            ps.setString(1,classid);  //设置参数1：班级编号
            rs=ps.executeQuery();
            while(rs.next()){
                    StuInfoBean stuInfoBean=new StuInfoBean();
                    //将每个班级信息保存到一个班级对象classinfobean中
                    stuInfoBean.setSchoolNo(rs.getString(1));
                    stuInfoBean.setStuNo(rs.getString(2));
                    stuInfoBean.setStuName(rs.getString(3));
                    stuInfoBean.setStuSpell(rs.getString(4));
                    stuInfoBean.setStuSex(rs.getString(5));
                    stuInfoBean.setStuIdentity(rs.getString(6));
                    stuInfoBean.setStuClassId(rs.getString(7));
                    stuInfoBean.setStuClassTeacher(rs.getString(8));
                    stuInfoBean.setStuState(rs.getString(9));
                    stuInfoBean.setStuCert(rs.getString(10));
                    stuInfoBean.setStuEdulevel(rs.getString(11));
                    stuInfoBean.setStuSpec(rs.getString(12));
                    stuInfoBean.setStuGraduSchool(rs.getString(13));
                    stuInfoBean.setStuWorkState(rs.getString(14));
                    stuInfoBean.setStuCompany(rs.getString(15));
                    stuInfoBean.setStuWorkType(rs.getString(16));
                    stuInfoBean.setStuTel(rs.getString(17));
                    stuInfoBean.setStuAdd(rs.getString(18));
                    stuInfoBean.setStuCode(rs.getString(19));
                    stuInfoBean.setStuJobCity(rs.getString(20));
                    stuInfoBean.setStuJobCompany(rs.getString(21));
                    stuInfoBean.setRemark(rs.getString(22));
                    //将查询出来的学员信息存放到一个动态数组当中
                    list.add(stuInfoBean);
            }//end while
        }catch (SQLException ex) {
            System.out.println("查询学员信息时出错");
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

    //学员入班，增加一个学员信息
    public int addStudent(StuInfoBean student){
        //设置要执行的sql语句
        String sqlstr1="insert into studentinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(1,student.getSchoolNo());  //设置参数1：中心编号
            ps.setString(2,student.getStuNo());//学号
            ps.setString(3,student.getStuName());//姓名
            ps.setString(4,student.getStuSpell());//姓名拼音
            ps.setString(5,student.getStuSex());//性别
            ps.setString(6,student.getStuIdentity());//身份证号
            ps.setString(7,student.getStuClassId());//班级编号
            ps.setString(8,student.getStuClassTeacher());//班主任姓名
            ps.setString(9,student.getStuState());//学员状态
            ps.setString(10,student.getStuCert());//已持有证书
            ps.setString(11,student.getStuEdulevel());//学历
            ps.setString(12,student.getStuSpec());//专业
            ps.setString(13,student.getStuGraduSchool());//毕业学校
            ps.setString(14,student.getStuWorkState());//工作状态
            ps.setString(15,student.getStuCompany());//工作单位
            ps.setString(16,student.getStuWorkType());//工作种类
            ps.setString(17,student.getStuTel());//联系电话
            ps.setString(18,student.getStuAdd());//通讯地址
            ps.setString(19,student.getStuCode());//邮编
            ps.setString(20,student.getStuJobCity());//就业意向城市
            ps.setString(21,student.getStuJobCompany());//就业意向单位
            ps.setString(22,student.getRemark());//备注

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
    }//end method:addStudent()

    //在数据库中删除某一班主任所带的某一班级的学员信息
    public int deleteStudent(String stuno){
        //设置要执行的sql语句
        String sqlstr="delete from studentinfo where rtrim(stuid)=?";
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
            System.out.println("删除学员信息时出错");
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

}
