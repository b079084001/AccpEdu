package com.accpedu.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.BorderLayout;
//import java.awt.Rectangle;
import com.accpedu.dao.DepartmentAction;
import com.accpedu.dao.TeacherAction;
import com.accpedu.model.ClassInfoBean;
import com.accpedu.model.DepartmentInfoBean;
import com.accpedu.model.TeacherInfoBean;
import com.accpedu.model.UserInfoBean;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
//import javax.swing.Box;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Insets;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import javax.swing.BorderFactory;

public class HRFrame extends JFrame implements ListSelectionListener{
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    XYLayout xYLayout1 = new XYLayout();
    TitledBorder titledBorder1 = new TitledBorder("");
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JPanel jPanel2 = new JPanel();
    //ButtonGroup buttonGroup1 = new ButtonGroup();
    JPanel tablePanel = new JPanel();
    XYLayout xYLayout2 = new XYLayout();
    JScrollPane jScrollPane1 = new JScrollPane();

    //JMenuBar jMenuBar1 = new JMenuBar();
    JMenuBar jMenuBar1 = null;
    //JMenu jMenuFile = new JMenu();
    //JMenuItem jMenuFileExit = new JMenuItem();
    //JMenu jMenuHelp = new JMenu();
    //JMenuItem jMenuHelpAbout = new JMenuItem();
    //JMenu jMenu1 = new JMenu();
    //JMenuItem jMenuItem1 = new JMenuItem();

    JTable teacherTable = new JTable(); //表

    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel19 = new JLabel();
    JLabel jLabel25 = new JLabel();
    JTextField teacher_1 = new JTextField();
    JTextField teacher_2 = new JTextField();
    JTextField teacher_3 = new JTextField();
    JTextField teacher_4 = new JTextField();
    JTextField teacher_5 = new JTextField();
    JTextField teacher_6 = new JTextField();
    JTextField teacher_7 = new JTextField();
    JTextField teacher_8 = new JTextField();
    JTextField teacher_10 = new JTextField();
    JButton addteacherButton = new JButton();
    JButton delteacherButton = new JButton();
    JButton modifyteacherButton = new JButton();
    JButton saveteacherButton = new JButton();
    JButton exitmanageButton = new JButton();
    JLabel jLabel3 = new JLabel();
    JButton teacherInfoButton = new JButton();
    javax.swing.JLabel jLabel4 = new JLabel();
    javax.swing.JLabel jLabel13 = new JLabel();
    javax.swing.JComboBox departComboBox = new JComboBox();
    javax.swing.JLabel jLabel14 = new JLabel();

    XYLayout xYLayout3 = new XYLayout();

    ArrayList teacherlist = null;
    ArrayList departmentlist = null; //所有部门
    UserInfoBean userinfo = null;
    ClassInfoBean classInfo = null;

    ListSelectionModel selectionMode = null;
    //部门.
    //hw01:行政部;hw02:市场部;h203:教质部;hw04:学术部;
    //hw05:就业部;hw06:财务部;hw07:后勤部;hw08:人事部;
    String department = "hw04"; //默认为学术部

    javax.swing.JComboBox jComboBox1 = new JComboBox();

    public HRFrame(UserInfoBean user) {
        //将登录用户的信息传递给教务管理窗口
        this.userinfo = user;

        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //设置欢迎词
        sayHello();
        //初始化departComboBox
        this.departmentlist = initDepartComboBox();
        initDetailDepart();
        //初始化Table表
        this.teacherlist = initTeacherTable();
    }

    private void jbInit() throws Exception {
        titledBorder1 = new TitledBorder(javax.swing.BorderFactory.
                                         createLineBorder(new Color(227, 212,
                234), 2), "请选择部门");
        getContentPane().setLayout(borderLayout1);
        jPanel1.setLayout(xYLayout1);
        jLabel1.setForeground(Color.red);
        jLabel1.setText("XXX老师");
        jLabel2.setForeground(Color.red);
        jLabel2.setText("上午好!欢迎您使用本系统!");
        jPanel2.setBackground(new Color(237, 234, 255));
        jPanel2.setBorder(titledBorder1);
        jPanel2.setLayout(xYLayout3);

        tablePanel.setBackground(new Color(237, 234, 255));
        tablePanel.setMinimumSize(new Dimension(725, 415));
        tablePanel.setPreferredSize(new Dimension(725, 415));
        tablePanel.setLayout(xYLayout2);
        teacherTable.setMaximumSize(new Dimension(500, 300));
        teacherTable.setPreferredSize(new Dimension(100, 165));
        jLabel5.setText("员工编号:");
        jLabel6.setText("姓名:");
        jLabel7.setText("出生日期:");
        jLabel8.setText("性别:");
        jLabel9.setText("毕业院校:");
        jLabel10.setText("专业:");
        jLabel11.setText("家庭地址:");
        jLabel12.setText("入职时间:");
        jLabel19.setText("部门:");
        jLabel25.setText("岗位:");
        addteacherButton.setAlignmentY((float) 0.0);
        addteacherButton.setMargin(new Insets(2, 2, 2, 2));
        addteacherButton.setText("入职新员工");
        addteacherButton.addActionListener(new
                                       HRFrame_addteacherButton_actionAdapter(this));
        delteacherButton.setMargin(new Insets(2, 2, 2, 2));
        delteacherButton.setText("员工离职");
        delteacherButton.addActionListener(new
                                       HRFrame_delteacherButton_actionAdapter(this));
        modifyteacherButton.setMargin(new Insets(2, 2, 2, 2));
        modifyteacherButton.setText("信息修改");
        modifyteacherButton.addActionListener(new
                HRFrame_modifyteacherButton_actionAdapter(this));
        saveteacherButton.setEnabled(false);
        saveteacherButton.setText("保存");
        saveteacherButton.addActionListener(new
                HRFrame_saveteacherButton_actionAdapter(this));
        exitmanageButton.setText("退出管理");
        exitmanageButton.addActionListener(new
                HRFrame_exitmanageButton_actionAdapter(this));
        teacherInfoButton.setMargin(new Insets(2, 2, 2, 2));
        teacherInfoButton.setText("查  看");
        teacherInfoButton.addActionListener(new
                HRFrame_teacherInfoButton_actionAdapter(this));
        teacher_5.setOpaque(false);
        teacher_5.setEditable(false);
        teacher_6.setOpaque(false);
        teacher_6.setEditable(false);
        teacher_7.setOpaque(false);
        teacher_7.setEditable(false);
        teacher_4.setOpaque(false);
        teacher_4.setEditable(false);
        teacher_10.setOpaque(false);
        teacher_10.setEditable(false);
        jLabel3.setText("    ");
        teacher_1.setOpaque(false);
        teacher_1.setEditable(false);
        this.setResizable(false);
        teacher_2.setOpaque(false);
        teacher_2.setEditable(false);
        teacher_3.setOpaque(false);
        teacher_3.setEditable(false);
        teacher_8.setOpaque(false);
        teacher_8.setEditable(false);
        jLabel13.setText("部门:");
        jLabel14.setText("jLabel14");
        jComboBox1.setEnabled(false);
        jComboBox1.setOpaque(false);
        departComboBox.addActionListener(new
                                         HRFrame_departComboBox_actionAdapter(this));

        //jMenuFile.setText("系统管理");
        //jMenuFileExit.setToolTipText("");
        //jMenuFileExit.setText("退出系统");
        //jMenuFileExit.addActionListener(new
                                        //HRFrame_jMenuFileExit_ActionAdapter(this));
        //jMenuHelp.setText("帮助");
        //jMenuHelpAbout.setText("关于");
        //jMenuHelpAbout.addActionListener(new
                                         //HRFrame_jMenuHelpAbout_ActionAdapter(this));

        jPanel1.setBackground(new Color(237, 234, 255));
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jLabel2, new XYConstraints(35, 45, 149, 27));
        jPanel1.add(jLabel1, new XYConstraints(67, 23, 94, 23));
        this.getContentPane().add(tablePanel, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(teacherTable);
        jPanel1.add(jLabel3, new XYConstraints(345, 81, -1, -1));


        tablePanel.add(jLabel5, new XYConstraints(24, 210, 59, -1));
        tablePanel.add(jLabel7, new XYConstraints(421, 210, 57, -1));
        tablePanel.add(teacher_3, new XYConstraints(477, 208, 88, 18));
        tablePanel.add(jLabel8, new XYConstraints(628, 210, 35, -1));
        jPanel1.add(teacherInfoButton, new XYConstraints(583, 46, 78, 19));
        jPanel1.add(jPanel2, new XYConstraints(261, 18, 298, 67));
        jPanel2.add(departComboBox, new XYConstraints(85, 9, 187, 19));
        jPanel2.add(jLabel13, new XYConstraints(51, 12, -1, -1));

        //jMenuBar1.setBackground(new Color(237, 234, 255));
        //jMenuBar1.setBorder(BorderFactory.createEtchedBorder());
        //jMenu1.setText("密码维护");
        //jMenuItem1.setText("更改密码");
        //jMenuItem1.addActionListener(new HRFrame_jMenuItem1_actionAdapter(this));
        //jMenu1.add(jMenuItem1);
        //jMenuBar1.add(jMenuFile);
        //jMenuBar1.add(jMenu1);
        //jMenuFile.add(jMenuFileExit);
        //jMenuBar1.add(jMenuHelp);
        //jMenuHelp.add(jMenuHelpAbout);
        MenuBar menuBar = new MenuBar(this,this.userinfo);
        jMenuBar1 = menuBar.createMenuBar();
        setJMenuBar(jMenuBar1);

        tablePanel.add(jScrollPane1, new XYConstraints(4, 3, 719, 191));
        tablePanel.add(jLabel6, new XYConstraints(230, 210, 35, -1));
        tablePanel.add(teacher_4, new XYConstraints(662, 208, 35, 18));
        tablePanel.add(jLabel12, new XYConstraints(24, 274, 59, 17));
        tablePanel.add(jLabel19, new XYConstraints(228, 277, -1, 18));
        tablePanel.add(teacher_10, new XYConstraints(462, 277, 79, 18));
        tablePanel.add(jLabel25, new XYConstraints(421, 278, -1, -1));
        tablePanel.add(modifyteacherButton, new XYConstraints(321, 327, 68, 20));
        tablePanel.add(delteacherButton, new XYConstraints(224, 327, 68, 20));
        tablePanel.add(saveteacherButton, new XYConstraints(418, 327, 68, 20));
        tablePanel.add(addteacherButton, new XYConstraints(116, 327, 81, 20));
        tablePanel.add(jLabel9, new XYConstraints(24, 242, 59, 17));
        tablePanel.add(teacher_5, new XYConstraints(83, 242, 105, 18));
        tablePanel.add(jLabel10, new XYConstraints(230, 243, 34, 17));
        tablePanel.add(teacher_6, new XYConstraints(264, 242, 108, 18));
        tablePanel.add(jLabel11, new XYConstraints(421, 244, 57, -1));
        tablePanel.add(teacher_1, new XYConstraints(84, 208, 105, 18));
        tablePanel.add(teacher_7, new XYConstraints(477, 242, 220, 18));
        tablePanel.add(teacher_8, new XYConstraints(82, 274, 106, 18));
        tablePanel.add(teacher_2, new XYConstraints(264, 208, 108, 18));
        tablePanel.add(jComboBox1, new XYConstraints(263, 277, 110, 17));
        tablePanel.add(exitmanageButton, new XYConstraints(576, 326, 86, 21));
    }

    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
/*    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
*/
    /**
     * Help | About action performed.
     *
     * @param actionEvent ActionEvent
     */
/*    void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        AboutBox dlg = new AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.setVisible(true);
    }
*/
    //设置欢迎词
        public void sayHello(){
            Calendar calendar = new GregorianCalendar();
            Date trialTime = new Date();
            calendar.setTime(trialTime);
            this.setTitle(userinfo.getUserId()+"人事管理界面");
            jLabel1.setText(userinfo.getUserId()+"老师");
            if(calendar.get(Calendar.HOUR_OF_DAY)>12){
                jLabel2.setText("下午好!欢迎您使用本系统!");
            }
        }

        //初始化部门信息
        public ArrayList initDepartComboBox(){
            DefaultComboBoxModel defaultComboBoxModel=new DefaultComboBoxModel();
            defaultComboBoxModel.addElement("全部");
            DepartmentAction departmentAction=new DepartmentAction();
            ArrayList list=departmentAction.findAllDepartments();
            Iterator it=list.iterator();
            while(it.hasNext()){
                DepartmentInfoBean departmentinfo=(DepartmentInfoBean)it.next();
                defaultComboBoxModel.addElement(departmentinfo.getDepartmentName());
            }
            departComboBox.setModel(defaultComboBoxModel);
            departComboBox.setSelectedIndex(0);
            return list;
        }

        //初始化详细信息(detail)部分的部门信息
        public void initDetailDepart(){
            DefaultComboBoxModel defaultComboBoxModel=new DefaultComboBoxModel();
            DepartmentAction departmentAction=new DepartmentAction();
            ArrayList list=departmentAction.findAllDepartments();
            Iterator it=list.iterator();
            while(it.hasNext()){
                DepartmentInfoBean departmentinfo=(DepartmentInfoBean)it.next();
                defaultComboBoxModel.addElement(departmentinfo.getDepartmentName());
            }
            jComboBox1.setModel(defaultComboBoxModel);
            jComboBox1.setSelectedIndex(0);
        }

        //初始化Table表
        public ArrayList initTeacherTable(){
            ArrayList list=this.getTeacherInfo();
            DefaultTableModel defaultTableModel1=new DefaultTableModel();
            defaultTableModel1.setColumnCount(0);
            defaultTableModel1.setRowCount(0);
            //添加表头
            defaultTableModel1.addColumn("员工编号");
            defaultTableModel1.addColumn("姓名");
            defaultTableModel1.addColumn("性别");
            defaultTableModel1.addColumn("毕业院校");
            defaultTableModel1.addColumn("专业");
            //添加表格内容
            TeacherInfoBean teacherinfo=null;
            int i=0;
            if(list!=null){
                Iterator it=list.iterator();
                while(it.hasNext()){
                    defaultTableModel1.setNumRows(i+1);
                    teacherinfo=(TeacherInfoBean)it.next();
                    defaultTableModel1.setValueAt(teacherinfo.getTeacherId(),i,0);
                    defaultTableModel1.setValueAt(teacherinfo.getTeacherName(),i,1);
                    defaultTableModel1.setValueAt(teacherinfo.getTeacherSex(),i,2);
                    defaultTableModel1.setValueAt(teacherinfo.getTeacherSchool(),i,3);
                    defaultTableModel1.setValueAt(teacherinfo.getTeacherTech(),i,4);
                    i++;
                }
            }else{
                System.out.println("error:HRFrame.initTeacherTable()");
            }
            teacherTable.setModel((TableModel)defaultTableModel1);
            //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
            //据时以整列为单位.
            teacherTable.setCellSelectionEnabled(true);

            //取得table的ListSelectionModel.
            selectionMode= teacherTable.getSelectionModel();
            selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
            teacherTable.revalidate();
            selectionMode.addListSelectionListener(this);
            return list;
        }

        //表格选取响应事件
        /*当用户选取表格数据时会触发ListSelectionEvent,
        * 我们实现ListSelectionListener界面来处理这一事件.ListSelectionListener界
        * 面只定义一个方法,那就是valueChanged().
        */
        public void valueChanged(ListSelectionEvent e) {
            //JTable的getSelectedRows()与getSelectedColumns()方法会返回已选取表格cell的index Array数据.
            //int[] rows=classTable.getSelectedRows();
            //int[] columns=classTable.getSelectedColumns();

            //设置详细班级信息到文本框中
            //JTable的getValueAt()方法会返回某行的cell数据,返回值是Object数据类型,因此我们要自行转成String数据类型.
            //String classid=(String)classTable.getValueAt(rows[0], columns[0]);
            int row= teacherTable.getSelectedRow();
            System.out.println("row="+row);
            //System.out.println("classid="+classid);
            if(row<0){
                row=0;
            }
            if(row>=0 && teacherlist.size()>0){
                TeacherInfoBean teacherinfo = (TeacherInfoBean) teacherlist.get(row);
                //给文本框赋值
                teacher_1.setText(teacherinfo.getTeacherId());
                teacher_2.setText(teacherinfo.getTeacherName());
                teacher_3.setText(teacherinfo.getTeacherBirthday());
                teacher_4.setText(teacherinfo.getTeacherSex());
                teacher_5.setText(teacherinfo.getTeacherSchool());
                teacher_6.setText(teacherinfo.getTeacherTech());
                teacher_7.setText(teacherinfo.getTeacherAddress());
                teacher_8.setText(teacherinfo.getTeacherInDate());
                jComboBox1.setSelectedIndex(row);
                teacher_10.setText(teacherinfo.getTeacherDuty());
            }
        }//end valueChanged()

        public void exitmanageButton_actionPerformed(ActionEvent e) {
            this.setVisible(false);
            this.invalidate();
            this.dispose();
            LoginFrame loginFrame=new LoginFrame();
            loginFrame.pack();
            // Center the window
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = loginFrame.getSize();
            if (frameSize.height > screenSize.height) {
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width) {
                frameSize.width = screenSize.width;
            }
            loginFrame.setLocation((screenSize.width - frameSize.width) / 2,
                             (screenSize.height - frameSize.height) / 2);
            loginFrame.setVisible(true);
        }

        //单击"查看"按钮
        public void teacherInfoButton_actionPerformed(ActionEvent e) {
            this.teacherlist=initTeacherTable();
            this.clearTeacherInfo();
            //tablePanel.repaint();
            this.repaint();
        }

        //增加一个新的员工信息
        public void addteacherButton_actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            if(e.getActionCommand().equals("入职新员工")){
            addteacherButton.setText("取消");
            setAllTextFieldEditable(true); //将文本框设置为可编辑
            clearTeacherInfo(); //首先清空所有文本框
            delteacherButton.setEnabled(false); //"删除"按钮失效
            modifyteacherButton.setEnabled(false); //"修改"按钮失效
            saveteacherButton.setEnabled(true);
            }else{
            addteacherButton.setText("入职新员工");
            setAllTextFieldEditable(false); //将文本框设置为不可编辑
            delteacherButton.setEnabled(true); //"删除"按钮生效
            modifyteacherButton.setEnabled(true); //"修改"按钮生效
            saveteacherButton.setEnabled(false);//"保存"按钮失效
            }
        }

        //设置文本框状态
        public void setAllTextFieldEditable(boolean isEnable){
            teacher_1.setEditable(isEnable);
            teacher_2.setEditable(isEnable);
            teacher_3.setEditable(isEnable);
            teacher_4.setEditable(isEnable);
            teacher_5.setEditable(isEnable);
            teacher_6.setEditable(isEnable);
            teacher_7.setEditable(isEnable);
            teacher_8.setEditable(isEnable);
            jComboBox1.setEnabled(isEnable);
            teacher_10.setEditable(isEnable);
        }

        //清空所有文本框
        public void clearTeacherInfo(){
            teacher_1.setText("");
            teacher_2.setText("");
            teacher_3.setText("");
            teacher_4.setText("");
            teacher_5.setText("");
            teacher_6.setText("");
            teacher_7.setText("");
            teacher_8.setText("");
            jComboBox1.setSelectedIndex(0);
            teacher_10.setText("");
        }

        //删除班级信息
        public void delteacherButton_actionPerformed(ActionEvent e) {
            String teacherId= teacher_1.getText().trim();
            if(teacherId.equals("")){
                JOptionPane.showMessageDialog(this,"请先选择要删除的员工！","警告",JOptionPane.WARNING_MESSAGE);
                teacher_1.requestFocus();
                return;
            }
            TeacherAction teacherAction=new TeacherAction();
            int line=0;
            int result = JOptionPane.showConfirmDialog(this,"您真的要删除此员工信息吗？", "删除确认", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){//选择：Yes or OK
                line=teacherAction.delTeacher(teacherId);//删除员工
                if(line==0)
                    JOptionPane.showMessageDialog(this,"删除失败，请检查！","警告",JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(this,"删除成功！","成功",JOptionPane.WARNING_MESSAGE);
                //重新初始化Table表
                this.teacherlist=initTeacherTable();
                this.repaint();
            }//end if
        }//end method

        //从员工信息表中获得ArrayList对象
        public ArrayList getTeacherInfo(){
            int selectedDepalrtment=departComboBox.getSelectedIndex();
            String department="%";
            switch(selectedDepalrtment){
                 case 0:department="%";break;
                 case 1:department="hw01";break;
                 case 2:department="hw02";break;
                 case 3:department="hw03";break;
                 case 4:department="hw04";break;
                 case 5:department="hw05";break;
                 case 6:department="hw06";break;
                 case 7:department="hw07";break;
                 case 8:department="hw08";break;
                 default:department="%";
            }
            ArrayList list=new ArrayList();
            TeacherAction teacherAction = new TeacherAction();
            list=teacherAction.findTeachersByDepart(department);
            return list;
        }

        //修改班级信息
        public void modifyteacherButton_actionPerformed(ActionEvent e) {
            String teacherId= teacher_1.getText().trim();
            if(teacherId.equals("")){
                JOptionPane.showMessageDialog(this,"请先选择要修改的员工！","警告",JOptionPane.WARNING_MESSAGE);
                teacher_1.requestFocus();
                return;
            }

            if(e.getActionCommand().equals("信息修改")){
                modifyteacherButton.setText("取消");
                setAllTextFieldEditable(true); //将文本框设置为可编辑
                delteacherButton.setEnabled(false); //"删除"按钮失效
                addteacherButton.setEnabled(false); //"增加"按钮失效
                saveteacherButton.setEnabled(true);
            }else{
                modifyteacherButton.setText("信息修改");
                setAllTextFieldEditable(false); //将文本框设置为晃可编辑
                delteacherButton.setEnabled(true); //"删除"按钮生效
                addteacherButton.setEnabled(true); //"增加"按钮生效
                saveteacherButton.setEnabled(false);
            }
        }

        //保存一个新的班级信息
    public void saveteacherButton_actionPerformed(ActionEvent e) {
        String teacherId= teacher_1.getText().trim();
        if(teacherId.equals("")){
            JOptionPane.showMessageDialog(this,"员工编号不能为空！","警告",JOptionPane.WARNING_MESSAGE);
            teacher_1.requestFocus();
            return;
        }

        //如果是保存新增加的员工信息,将员工信息同时增加到员工信息表
        if(addteacherButton.isEnabled()){
            TeacherInfoBean teacherinfo=createTeacher();//将员工信息封装到bean当中
            TeacherAction teacherAction=new TeacherAction();
            int result=teacherAction.addTeacher(teacherinfo);
            if(result==0){
                JOptionPane.showMessageDialog(this,"添加员工信息失败，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this,"添加员工信息成功","消息",JOptionPane.INFORMATION_MESSAGE);
                setAllTextFieldEditable(false);//重新将文本框设置为不可编辑
                saveteacherButton.setEnabled(false);//"保存"按钮失效
                addteacherButton.setText("增加新班");
                delteacherButton.setEnabled(true);//"删除"按钮生效
                modifyteacherButton.setEnabled(true);//"修改"按钮生效
            }
        }
        else if(modifyteacherButton.isEnabled()){//如果是保存修改过的班级信息
            TeacherInfoBean teacherinfo=createTeacher();//将员工信息封装到bean当中
            TeacherAction teacherAction=new TeacherAction();
            int result1=new TeacherAction().delTeacher(teacherId);
            if(result1==0){
                JOptionPane.showMessageDialog(this,"无法修改，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }
            int result2=new TeacherAction().addTeacher(teacherinfo);
            if(result2==0){
                JOptionPane.showMessageDialog(this,"修改员工信息失败，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this,"修改员工信息成功","消息",JOptionPane.INFORMATION_MESSAGE);
                setAllTextFieldEditable(false);//重新将文本框设置为不可编辑
                saveteacherButton.setEnabled(false);//"保存"按钮失效
                delteacherButton.setEnabled(true);//"删除"按钮生效
                addteacherButton.setEnabled(true);//"增加"按钮生效
                modifyteacherButton.setText("修改");
            }
        }
        //重新初始化Table表
        this.teacherlist=this.initTeacherTable();
        teacherTable.revalidate();
        tablePanel.repaint();
        //this.repaint();
    }

    //将文本框信息封闭到一个TeacherInfoBean当中
    public TeacherInfoBean createTeacher(){
        TeacherInfoBean teacherinfo=new TeacherInfoBean();
        //获取文本框的值
        teacherinfo.setTeacherId(teacher_1.getText().trim());
        teacherinfo.setTeacherName(teacher_2.getText().trim());
        teacherinfo.setTeacherBirthday(teacher_3.getText().trim());
        teacherinfo.setTeacherSex(teacher_4.getText().trim());
        teacherinfo.setTeacherSchool(teacher_5.getText().trim());
        teacherinfo.setTeacherTech(teacher_6.getText().trim());
        teacherinfo.setTeacherAddress(teacher_7.getText().trim());
        teacherinfo.setTeacherInDate(teacher_8.getText().trim());
        teacherinfo.setTeacherDepartment((String)jComboBox1.getSelectedItem());
        teacherinfo.setTeacherDuty(teacher_10.getText().trim());

        return teacherinfo;
    }

    public void departComboBox_actionPerformed(ActionEvent e) {

    }
/*
    //单击“修改密码”菜单
    public void jMenuItem1_actionPerformed(ActionEvent e) {
        UpdatePwdDialog dlg = new UpdatePwdDialog(this,"修改密码",true,this.userinfo);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.setVisible(true);
    }*/
}

/*
class HRFrame_jMenuItem1_actionAdapter implements ActionListener {
    private HRFrame adaptee;
    HRFrame_jMenuItem1_actionAdapter(HRFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}
*/

class HRFrame_departComboBox_actionAdapter implements ActionListener {
    private HRFrame adaptee;
    HRFrame_departComboBox_actionAdapter(HRFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.departComboBox_actionPerformed(e);
    }
}


class HRFrame_modifyteacherButton_actionAdapter implements ActionListener {
    private HRFrame adaptee;
    HRFrame_modifyteacherButton_actionAdapter(HRFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.modifyteacherButton_actionPerformed(e);
    }
}


class HRFrame_saveteacherButton_actionAdapter implements ActionListener {
    private HRFrame adaptee;
    HRFrame_saveteacherButton_actionAdapter(HRFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.saveteacherButton_actionPerformed(e);
    }
}


class HRFrame_delteacherButton_actionAdapter implements ActionListener {
    private HRFrame adaptee;
    HRFrame_delteacherButton_actionAdapter(HRFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.delteacherButton_actionPerformed(e);
    }
}


class HRFrame_addteacherButton_actionAdapter implements ActionListener {
    private HRFrame adaptee;
    HRFrame_addteacherButton_actionAdapter(HRFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.addteacherButton_actionPerformed(e);
    }
}


class HRFrame_teacherInfoButton_actionAdapter implements ActionListener {
        private HRFrame adaptee;
        HRFrame_teacherInfoButton_actionAdapter(HRFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            adaptee.teacherInfoButton_actionPerformed(e);
        }
    }

    class HRFrame_exitmanageButton_actionAdapter implements
            ActionListener {
        private HRFrame adaptee;
        HRFrame_exitmanageButton_actionAdapter(HRFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            adaptee.exitmanageButton_actionPerformed(e);
        }
    }

/*
    class HRFrame_jMenuFileExit_ActionAdapter implements ActionListener {
        HRFrame adaptee;

        HRFrame_jMenuFileExit_ActionAdapter(HRFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            adaptee.jMenuFileExit_actionPerformed(actionEvent);
        }
    }

    class HRFrame_jMenuHelpAbout_ActionAdapter implements ActionListener {
        HRFrame adaptee;

        HRFrame_jMenuHelpAbout_ActionAdapter(HRFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
        }
}
 */
