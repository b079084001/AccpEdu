package com.accpedu.view;

import javax.swing.*;
import java.awt.Dimension;

import com.accpedu.dao.ScoreAction;
import com.accpedu.dao.StudentAction;
import com.accpedu.dao.SubjectAction;
import com.accpedu.model.ClassInfoBean;
import com.accpedu.model.StuInfoBean;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ArchivesPanel extends JPanel  implements ListSelectionListener{
    XYLayout xYLayout1 = new XYLayout();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JTextField schoolNo = new JTextField();
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JTextField jTextField3 = new JTextField();
    JTextField jTextField4 = new JTextField();
    JTextField jTextField5 = new JTextField();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JTextField stuClassId = new JTextField();
    JLabel jLabel8 = new JLabel();
    JTextField stuClassTeacher = new JTextField();
    JLabel jLabel9 = new JLabel();
    JTextField jTextField6 = new JTextField();
    JLabel jLabel10 = new JLabel();
    JTextField jTextField7 = new JTextField();
    JLabel jLabel11 = new JLabel();
    JTextField jTextField8 = new JTextField();
    JLabel jLabel12 = new JLabel();
    JTextField jTextField9 = new JTextField();
    JLabel jLabel13 = new JLabel();
    JTextField jTextField10 = new JTextField();
    JLabel jLabel14 = new JLabel();
    JTextField jTextField11 = new JTextField();
    JLabel jLabel15 = new JLabel();
    JTextField jTextField12 = new JTextField();
    JLabel jLabel16 = new JLabel();
    JTextField jTextField13 = new JTextField();
    JLabel jLabel17 = new JLabel();
    JTextField jTextField14 = new JTextField();
    JLabel jLabel18 = new JLabel();
    JTextField jTextField15 = new JTextField();
    JLabel jLabel19 = new JLabel();
    JTextField jTextField16 = new JTextField();
    JLabel jLabel20 = new JLabel();
    JTextField jTextField17 = new JTextField();
    JLabel jLabel21 = new JLabel();
    JTextField jTextField18 = new JTextField();
    JLabel jLabel22 = new JLabel();
    JTextArea jTextArea1 = new JTextArea();
    JScrollPane jScrollPane1 = new JScrollPane();

    JTable stuTable = new JTable();

    JButton addButton = new JButton();
    JButton delButton = new JButton();
    JButton modifyButton = new JButton();
    JButton saveButton = new JButton();
    JButton exitButton = new JButton();

    String classid=null;//班级编号
    String classManager=null;//班主任编号
    String classSeme=null;//学期
    ArrayList stulist=new ArrayList();
    StuInfoBean stuinfo=null;
    ClassInfoBean classinfo=null;
    ListSelectionModel selectionMode=null;

    public ArchivesPanel(ClassInfoBean classinfo) {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        setAllTextFieldEditable(false);
        this.classinfo=classinfo;
        this.classid=classinfo.getClassId();//设置班级编号
        this.classManager=classinfo.getClassManager();//设置班主任编号
        this.classSeme=classinfo.getClassSeme();//设置学期号
        initStuInfo(this.classid,this.classManager);
        stulist=this.getStuInfo();
        //初始化Table表
        initStuTable();
    }

    private void jbInit() throws Exception {
        this.setLayout(xYLayout1);
        this.setBackground(new Color(237, 234, 255));
        this.setPreferredSize(new Dimension(725, 510));
        jLabel1.setText("中心编号:");
        jLabel2.setText("学号:");
        jLabel3.setText("姓名:");
        jLabel4.setText("姓名拼音(大写):");
        jLabel5.setText("性别:");
        schoolNo.addActionListener(new
                                      ArchivesPanel_jTextField1_actionAdapter(this));
        schoolNo.setOpaque(false);
        schoolNo.setEditable(false);
        schoolNo.setText("301");
        jTextField1.addActionListener(new
                                      ArchivesPanel_jTextField2_actionAdapter(this));
        jLabel6.setText("身份证号:");
        jLabel7.setText("班级:");
        stuClassId.setOpaque(false);
        stuClassId.setEditable(false);
        jLabel8.setText("班主任:");
        stuClassTeacher.setOpaque(false);
        stuClassTeacher.setEditable(false);
        jLabel9.setText("学员状态:");
        jLabel10.setText("已持有证书:");
        jLabel11.setText("学历:");
        jLabel12.setText("专业:");
        jLabel13.setToolTipText("");
        jLabel13.setText("毕业学校:");
        jLabel14.setText("工作状态:");
        jLabel15.setText("工作单位:");
        jLabel16.setText("工作种类:");
        jLabel17.setText("联系电话:");
        xYLayout1.setWidth(725);
        xYLayout1.setHeight(510);
        jLabel18.setToolTipText("");
        jLabel18.setText("通讯地址:");
        jLabel19.setText("邮编:");
        jLabel20.setText("就业意向城市:");
        jLabel21.setText("就业意向单位:");
        jLabel22.setText("备注:");
        jTextArea1.setBorder(BorderFactory.createLoweredBevelBorder());
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(4);
        addButton.setText("增加");
        addButton.addActionListener(new ArchivesPanel_addButton_actionAdapter(this));
        delButton.setText("删除");
        delButton.addActionListener(new ArchivesPanel_delButton_actionAdapter(this));
        modifyButton.setText("修改");
        modifyButton.addActionListener(new
                                       ArchivesPanel_modifyButton_actionAdapter(this));
        saveButton.setEnabled(false);
        saveButton.setText("保存");
        saveButton.addActionListener(new ArchivesPanel_saveButton_actionAdapter(this));
        exitButton.setText("退出系统");
        exitButton.addActionListener(new ArchivesPanel_exitButton_actionAdapter(this));
        stuTable.setPreferredSize(new Dimension(400, 243));
        jTextField1.setOpaque(false);
        jTextField2.setOpaque(false);
        jTextField3.setOpaque(false);
        jTextField4.setOpaque(false);
        jTextField5.setOpaque(false);
        jTextField6.setOpaque(false);
        jTextField7.setOpaque(false);
        jTextField8.setOpaque(false);
        jTextField9.setOpaque(false);
        jTextField10.setOpaque(false);
        jTextField14.setOpaque(false);
        jTextField18.setOpaque(false);
        jTextField17.setOpaque(false);
        jTextField13.setOpaque(false);
        jTextField12.setOpaque(false);
        jTextField11.setOpaque(false);
        jTextField15.setOpaque(false);
        jTextField16.setOpaque(false);
        this.add(jLabel1, new XYConstraints(12, 264, 60, 17));
        this.add(jLabel5, new XYConstraints(612, 264, 31, 17));
        this.add(jTextField4, new XYConstraints(646, 262, 55, -1));
        this.add(jLabel22, new XYConstraints(12, 429, -1, 17));
        this.add(jLabel10, new XYConstraints(12, 330, -1, 17));
        this.add(jLabel14, new XYConstraints(12, 363, -1, 17));
        this.add(jLabel18, new XYConstraints(12, 397, -1, 17));
        this.add(jTextField5, new XYConstraints(68, 294, 144, -1));
        this.add(jTextField15, new XYConstraints(68, 395, 185, -1));
        this.add(jLabel6, new XYConstraints(12, 297, 59, 17));
        this.add(jLabel7, new XYConstraints(219, 298, -1, -1));
        this.add(jLabel8, new XYConstraints(403, 298, -1, -1));
        this.add(jLabel9, new XYConstraints(563, 298, 61, -1));
        this.add(stuClassId, new XYConstraints(251, 294, 131, -1));
        this.add(stuClassTeacher, new XYConstraints(450, 294, 96, -1));
        this.add(jLabel11, new XYConstraints(196, 332, -1, -1));
        this.add(jLabel12, new XYConstraints(298, 332, -1, -1));
        this.add(jLabel13, new XYConstraints(498, 332, -1, -1));
        this.add(jTextField8, new XYConstraints(226, 327, 62, -1));
        this.add(jTextField9, new XYConstraints(331, 327, 152, -1));
        this.add(jTextField10, new XYConstraints(554, 327, 148, -1));
        this.add(jLabel15, new XYConstraints(126, 365, -1, -1));
        this.add(jLabel16, new XYConstraints(361, 365, -1, -1));
        this.add(jLabel17, new XYConstraints(512, 365, -1, -1));
        this.add(jTextField12, new XYConstraints(180, 360, 171, -1));
        this.add(jTextField14, new XYConstraints(570, 360, 132, -1));
        this.add(jLabel19, new XYConstraints(260, 399, -1, -1));
        this.add(jLabel20, new XYConstraints(360, 399, -1, -1));
        this.add(jLabel21, new XYConstraints(515, 399, -1, -1));
        this.add(jTextField18, new XYConstraints(592, 395, 109, -1));
        this.add(jTextArea1, new XYConstraints(42, 426, 342, 70));
        this.add(jScrollPane1, new XYConstraints(4, 4, 717, 248));
        this.add(addButton, new XYConstraints(413, 431, 73, 21));
        jScrollPane1.getViewport().add(stuTable);
        this.add(modifyButton, new XYConstraints(589, 431, 73, 21));
        this.add(delButton, new XYConstraints(501, 431, 73, 21));
        this.add(saveButton, new XYConstraints(456, 467, 73, 21));
        this.add(jTextField6, new XYConstraints(624, 294, 77, -1));
        this.add(jTextField13, new XYConstraints(415, 360, 86, -1));
        this.add(schoolNo, new XYConstraints(70, 262, 55, -1));
        this.add(jTextField11, new XYConstraints(69, 360, 49, -1));
        this.add(jTextField7, new XYConstraints(80, 327, 96, -1));
        this.add(jTextField17, new XYConstraints(442, 395, 70, -1));
        this.add(jTextField16, new XYConstraints(293, 395, 62, -1));
        this.add(exitButton, new XYConstraints(553, 467, 93, 21));
        this.add(jTextField1, new XYConstraints(166, 262, 130, -1));
        this.add(jLabel2, new XYConstraints(133, 264, 34, 17));
        this.add(jLabel3, new XYConstraints(306, 264, -1, 17));
        this.add(jTextField2, new XYConstraints(336, 262, 91, -1));
        this.add(jLabel4, new XYConstraints(432, 264, 93, 17));
        this.add(jTextField3, new XYConstraints(524, 262, 83, -1));
    }

    public void initStuInfo(String classid,String classManager){
        this.schoolNo.setText("301");
        this.stuClassId.setText(classid);
        this.stuClassTeacher.setText(classManager);
    }
    //设置文本框状态
    public void setAllTextFieldEditable(boolean isEnable){
        jTextField1.setEditable(isEnable);
        jTextField2.setEditable(isEnable);
        jTextField3.setEditable(isEnable);
        jTextField4.setEditable(isEnable);
        jTextField5.setEditable(isEnable);
        jTextField6.setEditable(isEnable);
        jTextField7.setEditable(isEnable);
        jTextField8.setEditable(isEnable);
        jTextField9.setEditable(isEnable);
        jTextField10.setEditable(isEnable);
        jTextField11.setEditable(isEnable);
        jTextField12.setEditable(isEnable);
        jTextField13.setEditable(isEnable);
        jTextField14.setEditable(isEnable);
        jTextField15.setEditable(isEnable);
        jTextField16.setEditable(isEnable);
        jTextField17.setEditable(isEnable);
        jTextField18.setEditable(isEnable);
        jTextArea1.setEditable(isEnable);
    }

    //初始化从学员信息表中获得ArrayList对象
    public ArrayList getStuInfo(){
        ArrayList list=new ArrayList();
        StudentAction stuAction = new StudentAction();
        list=stuAction.findStudentsByClassId(this.classid);
        return list;
    }

    //初始化Table表
    public void initStuTable(){
        DefaultTableModel defaultTableModel1=new DefaultTableModel();
        defaultTableModel1.setColumnCount(0);
        defaultTableModel1.setRowCount(0);
        //添加表头
        defaultTableModel1.addColumn("学号");
        defaultTableModel1.addColumn("姓名");
        defaultTableModel1.addColumn("性别");
        defaultTableModel1.addColumn("学员状态");
        defaultTableModel1.addColumn("学历");
        defaultTableModel1.addColumn("联系电话");
        //添加表格内容
        StuInfoBean stuinfo=null;
        int i=0;
        if(stulist!=null){
            Iterator it=stulist.iterator();
            while(it.hasNext()){
                defaultTableModel1.setNumRows(i+1);
                stuinfo=(StuInfoBean)it.next();
                defaultTableModel1.setValueAt(stuinfo.getStuNo(),i,0);
                defaultTableModel1.setValueAt(stuinfo.getStuName(),i,1);
                defaultTableModel1.setValueAt(stuinfo.getStuSex(),i,2);
                defaultTableModel1.setValueAt(stuinfo.getStuState(),i,3);
                defaultTableModel1.setValueAt(stuinfo.getStuEdulevel(),i,4);
                defaultTableModel1.setValueAt(stuinfo.getStuTel(),i,4);
                i++;
            }
            stuTable.setModel((TableModel)defaultTableModel1);
            this.repaint();
        }else{
            System.out.println("error:ArchivesPanel.initStuTable()");
        }

        //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
        //据时以整列为单位.
        stuTable.setCellSelectionEnabled(true);

        //取得table的ListSelectionModel.
        selectionMode=stuTable.getSelectionModel();
        selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
        stuTable.revalidate();
        selectionMode.addListSelectionListener(this);
    }


    public void jTextField1_actionPerformed(ActionEvent e) {

    }

    public void jTextField2_actionPerformed(ActionEvent e) {

    }

    //表格选取响应事件
    /*当用户选取表格数据时会触发ListSelectionEvent,
    * 我们实现ListSelectionListener界面来处理这一事件.ListSelectionListener界
    * 面只定义一个方法,那就是valueChanged().
    */
    public void valueChanged(ListSelectionEvent e) {
        int row=stuTable.getSelectedRow();
        System.out.println("row="+row);
        if(row>=0){
            StuInfoBean stuinfo = (StuInfoBean) stulist.get(row);
            //给文本框赋值
            schoolNo.setText(stuinfo.getSchoolNo()); //中心编号
            jTextField1.setText(stuinfo.getStuNo()); //学号
            jTextField2.setText(stuinfo.getStuName()); //姓名
            jTextField3.setText(stuinfo.getStuSpell()); //姓名拼音
            jTextField4.setText(stuinfo.getStuSex()); //性别
            jTextField5.setText(stuinfo.getStuIdentity()); //身份证号
            stuClassId.setText(stuinfo.getStuClassId()); //班级编号
            //stuClassTeacher.setText(stuinfo.getStuClassTeacher()); //班主任姓名
            stuClassTeacher.setText(this.classManager); //班主任姓名
            jTextField6.setText(stuinfo.getStuState()); //学员状态
            jTextField7.setText(stuinfo.getStuCert()); //已持有证书
            jTextField8.setText(stuinfo.getStuEdulevel()); //学历
            jTextField9.setText(stuinfo.getStuSpec()); //专业
            jTextField10.setText(stuinfo.getStuGraduSchool()); //毕业学校
            jTextField11.setText(stuinfo.getStuWorkState()); //工作状态
            jTextField12.setText(stuinfo.getStuCompany()); //工作单位
            jTextField13.setText(stuinfo.getStuWorkType()); //工作种类
            jTextField14.setText(stuinfo.getStuTel()); //联系电话
            jTextField15.setText(stuinfo.getStuAdd()); //通讯地址
            jTextField16.setText(stuinfo.getStuCode()); //邮编
            jTextField17.setText(stuinfo.getStuJobCity()); //就业意向城市
            jTextField18.setText(stuinfo.getStuJobCompany()); //就业意向单位
            jTextArea1.setText(stuinfo.getRemark()); //备注
        }
    }

    //退出系统
    public void exitButton_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    //增加一个新的学员
    public void addButton_actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("增加")){
            addButton.setText("取消");
            setAllTextFieldEditable(true); //将文本框设置为可编辑
            clearStuInfo(); //首先清空所有文本框
            delButton.setEnabled(false); //"删除"按钮失效
            modifyButton.setEnabled(false); //"修改"按钮失效
            saveButton.setEnabled(true);
        }else{
            addButton.setText("增加");
            setAllTextFieldEditable(false); //将文本框设置为不可编辑
            delButton.setEnabled(true); //"删除"按钮生效
            modifyButton.setEnabled(true); //"修改"按钮生效
            saveButton.setEnabled(false);//"保存"按钮失效
        }
    }//end addButton

    //清空所有文本框
    public void clearStuInfo(){
        jTextField1.setText("");//学号
        jTextField2.setText("");//姓名
        jTextField3.setText("");//姓名拼音
        jTextField4.setText("");//性别
        jTextField5.setText("");//身份证号
        //stuClassId.setText("");//班级编号
        //stuClassTeacher.setText("");//班主任姓名
        jTextField6.setText("");//学员状态
        jTextField7.setText("");//已持有证书
        jTextField8.setText("");//学历
        jTextField9.setText("");//专业
        jTextField10.setText(""); //毕业学校
        jTextField11.setText("");//工作状态
        jTextField12.setText("");//工作单位
        jTextField13.setText("");//工作种类
        jTextField14.setText("");//联系电话
        jTextField15.setText("");//通讯地址
        jTextField16.setText("");//邮编
        jTextField17.setText("");//就业意向城市
        jTextField18.setText("");//就业意向单位
        jTextArea1.setText("");//备注

    }

    //保存新增加的学员信息或修改过的学员信息
    public void saveButton_actionPerformed(ActionEvent e) {
        String stuNo=jTextField1.getText().trim();
        String stuName=jTextField2.getText().trim();
        String stuNameSpell=jTextField3.getText().trim();
        if(stuNo.equals("")){
            JOptionPane.showMessageDialog(this,"学员学号不能为空！","警告",JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
            return;
        }
        if(stuName.equals("")){
            JOptionPane.showMessageDialog(this,"学员姓名不能为空！","警告",JOptionPane.WARNING_MESSAGE);
            jTextField2.requestFocus();
            return;
        }
        if(stuNameSpell.equals("")){
           JOptionPane.showMessageDialog(this,"学员姓名拼音不能为空！","警告",JOptionPane.WARNING_MESSAGE);
           jTextField3.requestFocus();
           return;
       }

        if(addButton.isEnabled()){//如果是保存新增加的学员信息,将学员信息同时增加到学员信息表和成绩表当中
            StuInfoBean stuinfo=createStudent();
            StudentAction stuAction=new StudentAction();

            int result=stuAction.addStudent(stuinfo);
            if(result==0){
                JOptionPane.showMessageDialog(this,"添加学员信息失败，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this,"添加新学员信息成功","消息",JOptionPane.INFORMATION_MESSAGE);
                setAllTextFieldEditable(false);//重新将文本框设置为不可编辑
                saveButton.setEnabled(false);//"保存"按钮失效
                addButton.setText("增加");
                delButton.setEnabled(true);//"删除"按钮生效
                modifyButton.setEnabled(true);//"修改"按钮生效

                //向成绩表中添加学员信息
                ScoreAction scoreAction=new ScoreAction();//同时在成绩表中添加该名学员所有的初始科目成绩信息
                SubjectAction subjectAction=new SubjectAction();
                ArrayList subjectList=subjectAction.getAllSubjectInfo(this.classSeme);//查询某一学期的所有考试科目
                scoreAction.addStudentScore(stuinfo.getStuNo(),subjectList);//添加学号、科目号和成绩到成绩表当中
            }
        }
        else if(modifyButton.isEnabled()){//如果是保存修改过的学员信息
            StuInfoBean stuinfo=createStudent();
            //StudentAction stuAction=new StudentAction();
            int result1=new StudentAction().deleteStudent(stuNo);
            if(result1==0){
                JOptionPane.showMessageDialog(this,"无法修改，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }
            int result2=new StudentAction().addStudent(stuinfo);
            if(result2==0){
                JOptionPane.showMessageDialog(this,"修改学员信息失败，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this,"修改学员信息成功","消息",JOptionPane.INFORMATION_MESSAGE);
                setAllTextFieldEditable(false);//重新将文本框设置为不可编辑
                saveButton.setEnabled(false);//"保存"按钮失效
                delButton.setEnabled(true);//"删除"按钮生效
                addButton.setEnabled(true);//"增加"按钮生效
                modifyButton.setText("修改");
            }
        }

        //重新获取学员信息
        stulist=this.getStuInfo();
        //重新初始化Table表
        initStuTable();
        this.repaint();
    }//end saveButton

    //将文本框信息封闭到一个StuInfoBean当中
    public StuInfoBean createStudent(){
        StuInfoBean stuinfo=new StuInfoBean();
        //获取文本框的值
        stuinfo.setSchoolNo(schoolNo.getText());//中心编号
        stuinfo.setStuNo(jTextField1.getText());;//学号
        stuinfo.setStuName(jTextField2.getText());//姓名
        stuinfo.setStuSpell(jTextField3.getText());//姓名拼音
        stuinfo.setStuSex(jTextField4.getText());//性别
        stuinfo.setStuIdentity(jTextField5.getText());//身份证号
        stuinfo.setStuClassId(stuClassId.getText());//班级编号
        stuinfo.setStuClassTeacher(stuClassTeacher.getText());//班主任姓名
        stuinfo.setStuState(jTextField6.getText());//学员状态
        stuinfo.setStuCert(jTextField7.getText());//已持有证书
        stuinfo.setStuEdulevel(jTextField8.getText()); //学历
        stuinfo.setStuSpec(jTextField9.getText()); //专业
        stuinfo.setStuGraduSchool(jTextField10.getText()); //毕业学校
        stuinfo.setStuWorkState(jTextField11.getText());//工作状态
        stuinfo.setStuCompany(jTextField12.getText()); //工作单位
        stuinfo.setStuWorkType(jTextField13.getText());//工作种类
        stuinfo.setStuTel(jTextField14.getText());//联系电话
        stuinfo.setStuAdd(jTextField15.getText());//通讯地址
        stuinfo.setStuCode(jTextField16.getText());//邮编
        stuinfo.setStuJobCity(jTextField17.getText());//就业意向城市
        stuinfo.setStuJobCompany(jTextField18.getText());//就业意向单位
        stuinfo.setRemark(jTextArea1.getText());//备注

        return stuinfo;
    }

    //修改学员信息
    public void modifyButton_actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("修改")){
            modifyButton.setText("取消");
            setAllTextFieldEditable(true); //将文本框设置为可编辑
            delButton.setEnabled(false); //"删除"按钮失效
            addButton.setEnabled(false); //"增加"按钮失效
            saveButton.setEnabled(true);
        }else{
            modifyButton.setText("修改");
            setAllTextFieldEditable(false); //将文本框设置为晃可编辑
            delButton.setEnabled(true); //"删除"按钮生效
            addButton.setEnabled(true); //"增加"按钮生效
            saveButton.setEnabled(false);
        }
    }

    //删除学员信息
    public void delButton_actionPerformed(ActionEvent e) {
        String stuNo=jTextField1.getText().trim();
        if(stuNo.equals("")){
            JOptionPane.showMessageDialog(this,"请先选择要删除的学员！","警告",JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
            return;
        }
        StudentAction stuAction=new StudentAction();
        int line=0;
        int result = JOptionPane.showConfirmDialog(this,"您真的要删除此学员吗？", "删除确认", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){//选择：Yes or OK
            line=stuAction.deleteStudent(stuNo);//删除学员
            if(line==0)
                JOptionPane.showMessageDialog(this,"删除失败，请检查！","警告",JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog(this,"删除成功！","成功",JOptionPane.WARNING_MESSAGE);
        }//end if

        //重新获取学员信息
        stulist=this.getStuInfo();
        //重新初始化Table表
        initStuTable();
        this.repaint();
    }
}


class ArchivesPanel_delButton_actionAdapter implements ActionListener {
    private ArchivesPanel adaptee;
    ArchivesPanel_delButton_actionAdapter(ArchivesPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.delButton_actionPerformed(e);
    }
}


class ArchivesPanel_modifyButton_actionAdapter implements ActionListener {
    private ArchivesPanel adaptee;
    ArchivesPanel_modifyButton_actionAdapter(ArchivesPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.modifyButton_actionPerformed(e);
    }
}


class ArchivesPanel_saveButton_actionAdapter implements ActionListener {
    private ArchivesPanel adaptee;
    ArchivesPanel_saveButton_actionAdapter(ArchivesPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.saveButton_actionPerformed(e);
    }
}


class ArchivesPanel_addButton_actionAdapter implements ActionListener {
    private ArchivesPanel adaptee;
    ArchivesPanel_addButton_actionAdapter(ArchivesPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.addButton_actionPerformed(e);
    }
}


class ArchivesPanel_exitButton_actionAdapter implements ActionListener {
    private ArchivesPanel adaptee;
    ArchivesPanel_exitButton_actionAdapter(ArchivesPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.exitButton_actionPerformed(e);
    }
}


class ArchivesPanel_jTextField2_actionAdapter implements ActionListener {
    private ArchivesPanel adaptee;
    ArchivesPanel_jTextField2_actionAdapter(ArchivesPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jTextField2_actionPerformed(e);
    }
}


class ArchivesPanel_jTextField1_actionAdapter implements ActionListener {
    private ArchivesPanel adaptee;
    ArchivesPanel_jTextField1_actionAdapter(ArchivesPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jTextField1_actionPerformed(e);
    }
}
