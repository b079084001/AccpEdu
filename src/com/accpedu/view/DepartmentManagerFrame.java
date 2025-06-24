package com.accpedu.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.BorderLayout;

import com.accpedu.dao.ClassAction;
import com.accpedu.dao.UpdatePwdDialog;
import com.accpedu.model.ClassInfoBean;
import com.accpedu.model.UserInfoBean;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
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

public class DepartmentManagerFrame extends JFrame implements ListSelectionListener{
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    XYLayout xYLayout1 = new XYLayout();
    TitledBorder titledBorder1 = new TitledBorder("");
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JComboBox classComboBox = new JComboBox();
    JPanel jPanel2 = new JPanel();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JRadioButton jRadioButton1 = new JRadioButton();
    JRadioButton jRadioButton2 = new JRadioButton();
    JRadioButton jRadioButton3 = new JRadioButton();
    JPanel tablePanel = new JPanel();
    XYLayout xYLayout2 = new XYLayout();
    JScrollPane jScrollPane1 = new JScrollPane();

    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JMenu jMenu1 = new JMenu();
    JMenuItem jMenuItem1 = new JMenuItem();

    JTable classTable = new JTable();//表
    DefaultTableModel defaultTableModel1=new DefaultTableModel();

    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel13 = new JLabel();
    JLabel jLabel14 = new JLabel();
    JLabel jLabel15 = new JLabel();
    JLabel jLabel16 = new JLabel();
    JLabel jLabel17 = new JLabel();
    JLabel jLabel18 = new JLabel();
    JLabel jLabel19 = new JLabel();
    JLabel jLabel20 = new JLabel();
    JLabel jLabel21 = new JLabel();
    JLabel jLabel22 = new JLabel();
    JLabel jLabel23 = new JLabel();
    JLabel jLabel24 = new JLabel();
    JLabel jLabel25 = new JLabel();
    JTextField classId = new JTextField();
    JTextField classHQId = new JTextField();
    JTextField classTeacher = new JTextField();
    JTextField classManager = new JTextField();
    JTextField classBeginDate = new JTextField();
    JTextField classDutoEndDate = new JTextField();
    JTextField classTestDate = new JTextField();
    JTextField classType = new JTextField();
    JTextField classWeekTime = new JTextField();
    JTextField classBeginNumber = new JTextField();
    JTextField classStuIn = new JTextField();
    JTextField classStuOut = new JTextField();
    JTextField classStuPause = new JTextField();
    JTextField classNumber = new JTextField();
    JTextField classEndDate = new JTextField();
    JTextField classEndNumber = new JTextField();
    JTextField classGraduRate = new JTextField();
    JTextField classPassNumber = new JTextField();
    JTextField classGradeNumber = new JTextField();
    JTextField classRealRate = new JTextField();
    JTextField classSeme = new JTextField();
    JButton addstuButton = new JButton();
    JButton delstuButton = new JButton();
    JButton modifystuButton = new JButton();
    JButton savestuButton = new JButton();
    JButton exitmanageButton = new JButton();
    JLabel jLabel3 = new JLabel();
    JButton classInfoButton = new JButton();

    //班主任选择要管理的班级
    DefaultComboBoxModel classModel=new DefaultComboBoxModel();
    ArrayList classlist=new ArrayList();
    UserInfoBean userinfo=null;
    ClassInfoBean classInfo=null;

    ListSelectionModel selectionMode=null;

    JPanel oldPanel=null;//用来保存移除的班级浏览面板
    ArchivesPanel2 archivesPanel=null;
    ScoreManagerPanel2 scoreManagerPanel=null;
    TimeCheckPanel2 timeCheckPanel=null;
    int flag=0;//0:班级信息;1:考勤管理;2:成绩管理;3:档案管理

    XYLayout xYLayout3 = new XYLayout();
    public DepartmentManagerFrame(UserInfoBean user) {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        this.userinfo=user;//将登录用户的信息传递给班主任管理窗口

        //设置欢迎词
        sayHello();

        //加载窗口时，从数据库中查询出该班主任所带的班级，并显示在下拉列表中
        setClassComboBox();

        //初始化Table表
        initClassTable();
    }

    private void jbInit() throws Exception {
        titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(new
                Color(227, 212, 234), 2), "请选择查看内容");
        getContentPane().setLayout(borderLayout1);
        jPanel1.setLayout(xYLayout1);
        jLabel1.setForeground(Color.red);
        jLabel1.setText("XXX老师");
        jLabel2.setForeground(Color.red);
        jLabel2.setText("上午好!欢迎您使用本系统!");
        jLabel4.setText("请选择班级：");
        jPanel2.setBackground(new Color(237, 234, 255));
        jPanel2.setBorder(titledBorder1);
        jPanel2.setLayout(xYLayout3);
        jRadioButton1.setOpaque(false);
        jRadioButton1.setText("考勤");
        jRadioButton1.addActionListener(new
                DepartmentManagerFrame_jRadioButton1_actionAdapter(this));
        jRadioButton2.setOpaque(false);
        jRadioButton2.setText("成绩");
        jRadioButton2.addActionListener(new
                DepartmentManagerFrame_jRadioButton2_actionAdapter(this));
        jRadioButton3.setOpaque(false);
        jRadioButton3.setText("学员信息");
        jRadioButton3.addActionListener(new
                DepartmentManagerFrame_jRadioButton3_actionAdapter(this));
        tablePanel.setBackground(new Color(237, 234, 255));
        tablePanel.setMinimumSize(new Dimension(725, 415));
        tablePanel.setPreferredSize(new Dimension(725, 415));
        tablePanel.setLayout(xYLayout2);
        classTable.setMaximumSize(new Dimension(500, 300));
        classTable.setPreferredSize(new Dimension(100, 165));
        jLabel5.setText("班级编号:");
        jLabel6.setText("总部班级编号:");
        jLabel7.setText("授课教员:");
        jLabel8.setText("班主任:");
        jLabel9.setText("开课日期:");
        jLabel10.setText("预计结课日期:");
        jLabel11.setText("预计参加考试时间:");
        jLabel12.setText("班型:");
        jLabel13.setText("周课时数:");
        jLabel14.setText("开课人数:");
        jLabel15.setText("输入:");
        jLabel16.setText("输出:");
        jLabel17.setText("休学:");
        jLabel18.setText("班级人数:");
        jLabel19.setText("结课日期:");
        jLabel20.setText("结课时人数:");
        jLabel21.setText("预计升学率:");
        jLabel22.setText("获证人数:");
        jLabel23.setText("实际升学人数:");
        jLabel24.setText("实际升学率:");
        jLabel25.setText("学期:");
        addstuButton.setEnabled(false);
        addstuButton.setText("增加");
        delstuButton.setEnabled(false);
        delstuButton.setText("删除");
        modifystuButton.setEnabled(false);
        modifystuButton.setText("修改");
        modifystuButton.addActionListener(new
                DepartmentManagerFrame_modifystuButton_actionAdapter(this));
        savestuButton.setEnabled(false);
        savestuButton.setText("保存");
        exitmanageButton.setText("退出管理");
        exitmanageButton.addActionListener(new
                DepartmentManagerFrame_exitmanageButton_actionAdapter(this));
        classComboBox.setModel(classModel);
        classComboBox.addActionListener(new
                DepartmentManagerFrame_classComboBox_actionAdapter(this));
        classInfoButton.setEnabled(false);
        classInfoButton.setOpaque(false);
        classInfoButton.setMargin(new Insets(2, 2, 2, 2));
        classInfoButton.setText("班级信息");
        classInfoButton.addActionListener(new
                DepartmentManagerFrame_classInfoButton_actionAdapter(this));
        classBeginDate.setOpaque(false);
        classBeginDate.setEditable(false);
        classDutoEndDate.setOpaque(false);
        classDutoEndDate.setEditable(false);
        classWeekTime.setOpaque(false);
        classWeekTime.setEditable(false);
        classNumber.setOpaque(false);
        classNumber.setEditable(false);
        classPassNumber.setOpaque(false);
        classPassNumber.setEditable(false);
        classGradeNumber.setOpaque(false);
        classGradeNumber.setEditable(false);
        classEndDate.setOpaque(false);
        classEndDate.setEditable(false);
        classBeginNumber.setOpaque(false);
        classBeginNumber.setEditable(false);
        classStuIn.setOpaque(false);
        classStuIn.setEditable(false);
        classTestDate.setOpaque(false);
        classTestDate.setEditable(false);
        classStuOut.setOpaque(false);
        classStuOut.setEditable(false);
        classEndNumber.setOpaque(false);
        classEndNumber.setEditable(false);
        classRealRate.setOpaque(false);
        classRealRate.setEditable(false);
        classManager.setOpaque(false);
        classManager.setEditable(false);
        classStuPause.setOpaque(false);
        classStuPause.setEditable(false);
        classGraduRate.setOpaque(false);
        classGraduRate.setEditable(false);
        classSeme.setOpaque(false);
        classSeme.setEditable(false);
        jLabel3.setText("    ");
        classId.setBackground(new Color(237, 234, 250));
        classId.setOpaque(false);
        classId.setEditable(false);
        this.setResizable(false);
        classHQId.setOpaque(false);
        classHQId.setEditable(false);
        classTeacher.setOpaque(false);
        classTeacher.setEditable(false);
        classType.setOpaque(false);
        classType.setEditable(false);
        jPanel1.setBackground(new Color(237, 234, 255));
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jMenuItem1.addActionListener(new
                DepartmentManagerFrame_jMenuItem1_actionAdapter(this));
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jLabel4, new XYConstraints(225, 13, 83, 26));
        jPanel1.add(jLabel2, new XYConstraints(35, 45, 149, 27));
        jPanel1.add(jLabel1, new XYConstraints(67, 23, 94, 23));
        jPanel1.add(jPanel2, new XYConstraints(404, 17, 302, 67));

        jMenuFile.setText("系统管理");
        jMenuFileExit.setToolTipText("");
        jMenuFileExit.setText("退出系统");
        jMenuFileExit.addActionListener(new
                                        DepartmentManagerFrame_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setText("帮助");
        jMenuHelpAbout.setText("关于");
        jMenuHelpAbout.addActionListener(new
                                         DepartmentManagerFrame_jMenuHelpAbout_ActionAdapter(this));

        this.getContentPane().add(tablePanel, java.awt.BorderLayout.CENTER);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton1);
        jScrollPane1.getViewport().add(classTable);
        jPanel1.add(classComboBox, new XYConstraints(226, 39, 153, 17));
        jPanel1.add(classInfoButton, new XYConstraints(264, 62, 72, 19));
        jPanel1.add(jLabel3, new XYConstraints(345, 81, -1, -1));

        jMenuBar1.setBackground(new Color(237, 234, 255));
        jMenuBar1.setBorder(BorderFactory.createEtchedBorder());
        jMenu1.setText("密码维护");
        jMenuItem1.setText("更改密码");
        jMenu1.add(jMenuItem1);
        jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenu1);
        jMenuFile.add(jMenuFileExit);
        jMenuBar1.add(jMenuHelp);
        jMenuHelp.add(jMenuHelpAbout);
        setJMenuBar(jMenuBar1);

        tablePanel.add(classStuIn, new XYConstraints(360, 263, 65, 18));
        tablePanel.add(jLabel5, new XYConstraints(24, 210, 59, -1));
        tablePanel.add(classId, new XYConstraints(84, 208, 133, 18));
        tablePanel.add(jLabel6, new XYConstraints(230, 210, 84, -1));
        tablePanel.add(classHQId, new XYConstraints(309, 208, 93, 18));
        tablePanel.add(jLabel7, new XYConstraints(421, 210, 57, -1));
        tablePanel.add(classTeacher, new XYConstraints(477, 208, 88, 18));
        tablePanel.add(classManager, new XYConstraints(622, 208, 75, 18));
        tablePanel.add(classType, new XYConstraints(622, 236, 75, 18));
        tablePanel.add(jLabel12, new XYConstraints(589, 236, 33, 17));
        tablePanel.add(classTestDate, new XYConstraints(490, 236, 88, 18));
        tablePanel.add(jLabel11, new XYConstraints(380, 238, 111, -1));
        tablePanel.add(classDutoEndDate, new XYConstraints(271, 236, 101, 18));
        tablePanel.add(jLabel10, new XYConstraints(187, 236, 84, 17));
        tablePanel.add(classBeginDate, new XYConstraints(83, 236, 98, 18));
        tablePanel.add(jLabel9, new XYConstraints(24, 236, 59, 17));
        tablePanel.add(jLabel13, new XYConstraints(24, 261, 59, 20));
        tablePanel.add(classWeekTime, new XYConstraints(83, 263, 59, 18));
        tablePanel.add(jLabel14, new XYConstraints(188, 263, 56, 19));
        tablePanel.add(classBeginNumber, new XYConstraints(245, 263, 59, 18));
        tablePanel.add(jLabel15, new XYConstraints(326, 261, 33, 21));
        tablePanel.add(jLabel16, new XYConstraints(448, 260, 36, 22));
        tablePanel.add(classStuOut, new XYConstraints(481, 263, 67, 18));
        tablePanel.add(jLabel17, new XYConstraints(581, 264, 32, -1));
        tablePanel.add(classStuPause, new XYConstraints(617, 263, 80, 18));
        tablePanel.add(classGraduRate, new XYConstraints(628, 289, 67, 18));
        tablePanel.add(jLabel21, new XYConstraints(558, 289, -1, -1));
        tablePanel.add(classEndNumber, new XYConstraints(483, 289, 64, 18));
        tablePanel.add(jLabel20, new XYConstraints(412, 289, -1, -1));
        tablePanel.add(classEndDate, new XYConstraints(246, 289, 87, 18));
        tablePanel.add(jLabel19, new XYConstraints(187, 289, -1, 18));
        tablePanel.add(classNumber, new XYConstraints(83, 289, 78, 18));
        tablePanel.add(jLabel18, new XYConstraints(24, 289, -1, -1));
        tablePanel.add(jLabel22, new XYConstraints(23, 316, -1, -1));
        tablePanel.add(classPassNumber, new XYConstraints(82, 315, 79, 18));
        tablePanel.add(jLabel23, new XYConstraints(187, 316, -1, -1));
        tablePanel.add(classGradeNumber, new XYConstraints(266, 314, 89, 18));
        tablePanel.add(jLabel24, new XYConstraints(413, 316, -1, -1));
        tablePanel.add(classRealRate, new XYConstraints(483, 316, 63, 18));
        tablePanel.add(jLabel25, new XYConstraints(575, 316, -1, -1));
        tablePanel.add(classSeme, new XYConstraints(616, 315, 79, 18));
        tablePanel.add(savestuButton, new XYConstraints(401, 365, 68, 20));
        tablePanel.add(addstuButton, new XYConstraints(137, 365, 68, 20));
        tablePanel.add(delstuButton, new XYConstraints(229, 365, 68, 20));
        tablePanel.add(modifystuButton, new XYConstraints(313, 365, 68, 20));
        tablePanel.add(exitmanageButton, new XYConstraints(566, 364, 86, 21));
        tablePanel.add(jLabel8, new XYConstraints(580, 210, 45, -1));
        tablePanel.add(jScrollPane1, new XYConstraints(1, 3, 722, 191));
        jPanel2.add(jRadioButton3, new XYConstraints(186, 5, -1, -1));
        jPanel2.add(jRadioButton2, new XYConstraints(108, 5, -1, -1));
        jPanel2.add(jRadioButton1, new XYConstraints(30, 5, -1, -1));
    }

    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Help | About action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
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

    //设置欢迎词
    public void sayHello(){
        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        //jLabel1.setText(calendar.get(Calendar.AM_PM)+"");
        this.setTitle(userinfo.getUserId()+"教质经理管理界面");
        jLabel1.setText(userinfo.getUserId()+"经理");
        if(calendar.get(Calendar.HOUR_OF_DAY)>12){
            jLabel2.setText("下午好!欢迎您使用本系统!");
        }
    }

    //加载窗口时，从数据库中查询出中心所有班级，并显示在下拉列表中
    public void setClassComboBox(){
        classModel.addElement("--请选择班级--");
        ClassAction classAction = new ClassAction();
        ClassInfoBean classinfo=null;
        classlist=classAction.findAllClassBySeme("%");
        //填充下拉列表
        if(classlist!=null){
            Iterator it=classlist.iterator();
            while(it.hasNext()){
                classinfo=(ClassInfoBean)it.next();
                classModel.addElement(classinfo.getClassId());
            }
        }else{
            System.out.println("error:DepartmentManagerFrame.setClassComboBox()");
        }
    }

    //初始化Table表
    public void initClassTable(){
        defaultTableModel1.setColumnCount(0);
        defaultTableModel1.setRowCount(0);
        //添加表头
        defaultTableModel1.addColumn("班级编号");
        defaultTableModel1.addColumn("授课教员");
        defaultTableModel1.addColumn("班主任");
        defaultTableModel1.addColumn("开课日期");
        defaultTableModel1.addColumn("班级人数");
        //添加表格内容
        ClassInfoBean classinfo=null;
        int i=0;
        if(classlist!=null){
            Iterator it=classlist.iterator();
            while(it.hasNext()){
                defaultTableModel1.setNumRows(i+1);
                classinfo=(ClassInfoBean)it.next();
                defaultTableModel1.setValueAt(classinfo.getClassId(),i,0);
                defaultTableModel1.setValueAt(classinfo.getClassTeacher(),i,1);
                defaultTableModel1.setValueAt(classinfo.getClassManager(),i,2);
                defaultTableModel1.setValueAt(classinfo.getClassBeginDate(),i,3);
                defaultTableModel1.setValueAt(classinfo.getClassNumber(),i,4);
                i++;
            }
            classTable.setModel((TableModel)defaultTableModel1);
        }else{
            System.out.println("error:DepartmentManagerFrame.initClassTable()");
        }

        //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
        //据时以整列为单位.
        classTable.setCellSelectionEnabled(true);

        //取得table的ListSelectionModel.
        selectionMode=classTable.getSelectionModel();
        selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
        classTable.revalidate();
        selectionMode.addListSelectionListener(this);
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
        int row=classTable.getSelectedRow();
        System.out.println("row="+row);
        //System.out.println("classid="+classid);
        ClassInfoBean classinfo=(ClassInfoBean)classlist.get(row);
        //给文本框赋值
        classId.setText(classinfo.getClassId());
        classHQId.setText(classinfo.getClassHQId());
        classTeacher.setText(classinfo.getClassTeacher());
        classManager.setText(classinfo.getClassManager());
        classBeginDate.setText(classinfo.getClassBeginDate());
        classDutoEndDate.setText(classinfo.getClassDutoEndDate());//预计结课日期
        classTestDate.setText(classinfo.getClassTestDate());//预计参加考试时间
        classType.setText(classinfo.getClassType());//班级种类
        classWeekTime.setText(""+classinfo.getClassWeekTime());//周课时数
        classBeginNumber.setText(""+classinfo.getClassBeginNumber());//开课人数
        classStuIn.setText(""+classinfo.getClassStuIn());//转入
        classStuOut.setText(""+classinfo.getClassStuOut());//转出
        classStuPause.setText(""+classinfo.getClassStuPause()); //休学
        classNumber.setText(""+classinfo.getClassNumber());//班级人数
        classEndDate.setText(classinfo.getClassEndDate());//结课日期
        classEndNumber.setText(""+classinfo.getClassEndNumber());//结课时人数
        classGraduRate.setText(""+classinfo.getClassGraduRate());//预计升学率
        classPassNumber.setText(""+classinfo.getClassPassNumber());//获证人数
        classGradeNumber.setText(""+classinfo.getClassGradeNumber());//实际升学人数
        classRealRate.setText(""+classinfo.getClassRealRate());//实际升学率
        classSeme.setText(classinfo.getClassSeme());//学期

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

    //单击"档案管理"单选按钮,以管理某一班级的学员信息
    public void jRadioButton3_actionPerformed(ActionEvent e) {
        if(classComboBox.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"请先在左边选择要管理的班级","警告",JOptionPane.WARNING_MESSAGE);
            jRadioButton3.setSelected(false);
            return;
        }
        //int flag=0;//0:班级信息;1:考勤管理;2:成绩管理;3:档案管理
        //JPanel oldPanel=null;
        switch(flag){
           case 0:
               oldPanel=this.tablePanel;
               //this.getContentPane().remove(this.tablePanel);
               break;
           case 1:
               oldPanel=this.timeCheckPanel;
               //this.getContentPane().remove(this.timeCheckPanel);
               break;
           case 2:
               oldPanel=this.scoreManagerPanel;
               //this.getContentPane().remove(this.scoreManagerPanel);
               break;
           case 3:
               oldPanel=this.archivesPanel;
               //this.getContentPane().remove(this.scoreManagerPanel);
               break;
       }
       this.archivesPanel = new ArchivesPanel2(this.classInfo);
        this.getContentPane().remove(oldPanel);
        this.classInfoButton.setEnabled(true);
        this.getContentPane().add(archivesPanel,java.awt.BorderLayout.CENTER);
        this.flag=3;
        this.pack();
        this.repaint();
    }

    //重新返回班级信息面板
    public void classInfoButton_actionPerformed(ActionEvent e) {
        if(this.flag==1){//应该移除考勤管理窗口
            this.getContentPane().remove(this.timeCheckPanel);
            this.classInfoButton.setEnabled(false);
            this.getContentPane().add(this.tablePanel,java.awt.BorderLayout.CENTER);
            this.pack();
            this.repaint();
        }
        if(this.flag==2){//应该移除成绩管理窗口
            this.getContentPane().remove(this.scoreManagerPanel);
            this.classInfoButton.setEnabled(false);
            this.getContentPane().add(this.tablePanel,java.awt.BorderLayout.CENTER);
            this.pack();
            this.repaint();
        }
        if(this.flag==3){//应该移除档案管理窗口
            this.getContentPane().remove(this.archivesPanel);
            this.classInfoButton.setEnabled(false);
            this.getContentPane().add(this.tablePanel,java.awt.BorderLayout.CENTER);
            this.pack();
            this.repaint();
        }
        this.flag=0;
    }

    //单击"成绩管理"单选按钮,以管理某一班级的成绩信息
    public void jRadioButton2_actionPerformed(ActionEvent e) {
        if(classComboBox.getSelectedIndex()==0){
           JOptionPane.showMessageDialog(this,"请先在左边选择要管理的班级","警告",JOptionPane.WARNING_MESSAGE);
           jRadioButton2.setSelected(false);
           return;
       }
       //int flag=0;//0:班级信息;1:考勤管理;2:成绩管理;3:档案管理
       //JPanel oldPanel=null;
       switch(flag){
           case 0:
               oldPanel=this.tablePanel;
               break;
           case 1:
               oldPanel=this.timeCheckPanel;
               break;
           case 2:
               oldPanel=this.scoreManagerPanel;
               break;
           case 3:
               oldPanel=this.archivesPanel;
               break;
       }
       this.scoreManagerPanel=new ScoreManagerPanel2(this.classInfo);
       this.getContentPane().remove(oldPanel);
       this.classInfoButton.setEnabled(true);
       this.getContentPane().add(this.scoreManagerPanel,java.awt.BorderLayout.CENTER);
       this.flag=2;
       this.pack();
       this.repaint();
    }

    //选择要操作的班级
    public void classComboBox_actionPerformed(ActionEvent e) {
        String classid=(String)classComboBox.getSelectedItem();
        System.out.println("您选择的班级是："+classid);
        this.classInfo=getSelectedClass(classid);
    }
    //根据班级编号从数据库当中查询出该班信息
    public ClassInfoBean getSelectedClass(String classid){
        ClassInfoBean classinfo=null;
        ClassAction classAction=new ClassAction();
        classinfo=classAction.getClassInfoByClassId(classid);
        return classinfo;
    }

    //单击"考勤管理"单选按钮,以管理某一班级的考勤信息
    public void jRadioButton1_actionPerformed(ActionEvent e) {
        if(classComboBox.getSelectedIndex()==0){
           JOptionPane.showMessageDialog(this,"请先在左边选择要管理的班级","警告",JOptionPane.WARNING_MESSAGE);
           jRadioButton2.setSelected(false);
           return;
       }
       //int flag=0;//0:班级信息;1:考勤管理;2:成绩管理;3:档案管理
       //JPanel oldPanel=null;
       switch(flag){
           case 0:
               oldPanel=this.tablePanel;
               break;
           case 1:
               oldPanel=this.timeCheckPanel;
               break;
           case 2:
               oldPanel=this.scoreManagerPanel;
               break;
           case 3:
               oldPanel=this.archivesPanel;
               break;
       }
       this.timeCheckPanel=new TimeCheckPanel2(this.classInfo);
       this.getContentPane().remove(oldPanel);
       this.classInfoButton.setEnabled(true);
       this.getContentPane().add(this.timeCheckPanel,java.awt.BorderLayout.CENTER);
       this.flag=1;
       this.pack();
       this.repaint();
    }

    public void modifystuButton_actionPerformed(ActionEvent e) {

    }

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
    }
}


class DepartmentManagerFrame_jMenuItem1_actionAdapter implements ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_jMenuItem1_actionAdapter(DepartmentManagerFrame
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}


class DepartmentManagerFrame_modifystuButton_actionAdapter implements ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_modifystuButton_actionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.modifystuButton_actionPerformed(e);
    }
}


class DepartmentManagerFrame_classComboBox_actionAdapter implements ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_classComboBox_actionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.classComboBox_actionPerformed(e);
    }
}


class DepartmentManagerFrame_jRadioButton2_actionAdapter implements ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_jRadioButton2_actionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton2_actionPerformed(e);
    }
}


class DepartmentManagerFrame_jRadioButton1_actionAdapter implements ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_jRadioButton1_actionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton1_actionPerformed(e);
    }
}


class DepartmentManagerFrame_classInfoButton_actionAdapter implements ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_classInfoButton_actionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.classInfoButton_actionPerformed(e);
    }
}


class DepartmentManagerFrame_jRadioButton3_actionAdapter implements ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_jRadioButton3_actionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton3_actionPerformed(e);
    }
}


class DepartmentManagerFrame_exitmanageButton_actionAdapter implements
        ActionListener {
    private DepartmentManagerFrame adaptee;
    DepartmentManagerFrame_exitmanageButton_actionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.exitmanageButton_actionPerformed(e);
    }
}

class DepartmentManagerFrame_jMenuFileExit_ActionAdapter implements ActionListener {
    DepartmentManagerFrame adaptee;

    DepartmentManagerFrame_jMenuFileExit_ActionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class DepartmentManagerFrame_jMenuHelpAbout_ActionAdapter implements ActionListener {
    DepartmentManagerFrame adaptee;

    DepartmentManagerFrame_jMenuHelpAbout_ActionAdapter(DepartmentManagerFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}
