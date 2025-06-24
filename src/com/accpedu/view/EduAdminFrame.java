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

public class EduAdminFrame extends JFrame implements ListSelectionListener{
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    XYLayout xYLayout1 = new XYLayout();
    TitledBorder titledBorder1 = new TitledBorder("");
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
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
    XYLayout xYLayout3 = new XYLayout();

    ArrayList classlist=null;
    UserInfoBean userinfo=null;
    ClassInfoBean classInfo=null;

    ListSelectionModel selectionMode=null;
    int flag=0;//0:S1;  1:S2;  2:Y2

    public EduAdminFrame(UserInfoBean user) {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //将登录用户的信息传递给教务管理窗口
        this.userinfo=user;

        //设置欢迎词
        sayHello();

        //初始化Table表
        this.classlist=initClassTable();
    }

    private void jbInit() throws Exception {
        titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(new
                Color(227, 212, 234), 2), "请选择管理学期");
        getContentPane().setLayout(borderLayout1);
        jPanel1.setLayout(xYLayout1);
        jLabel1.setForeground(Color.red);
        jLabel1.setText("XXX老师");
        jLabel2.setForeground(Color.red);
        jLabel2.setText("上午好!欢迎您使用本系统!");
        jPanel2.setBorder(titledBorder1);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(xYLayout3);
        jRadioButton1.setOpaque(false);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("S1");
        jRadioButton1.addActionListener(new
                EduAdminFrame_jRadioButton1_actionAdapter(this));
        jRadioButton2.setOpaque(false);
        jRadioButton2.setText("S2");
        jRadioButton2.addActionListener(new
                EduAdminFrame_jRadioButton2_actionAdapter(this));
        jRadioButton3.setOpaque(false);
        jRadioButton3.setText("Y2");
        jRadioButton3.addActionListener(new
                EduAdminFrame_jRadioButton3_actionAdapter(this));
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
        addstuButton.setText("增加新班");
        addstuButton.addActionListener(new
                                       EduAdminFrame_addstuButton_actionAdapter(this));
        delstuButton.setText("删除");
        delstuButton.addActionListener(new
                                       EduAdminFrame_delstuButton_actionAdapter(this));
        modifystuButton.setText("修改");
        modifystuButton.addActionListener(new
                                          EduAdminFrame_jButton3_actionAdapter(this));
        savestuButton.setEnabled(false);
        savestuButton.setText("保存");
        savestuButton.addActionListener(new
                EduAdminFrame_savestuButton_actionAdapter(this));
        exitmanageButton.setText("退出管理");
        exitmanageButton.addActionListener(new
                EduAdminFrame_exitmanageButton_actionAdapter(this));
        classInfoButton.setMargin(new Insets(2, 2, 2, 2));
        classInfoButton.setText("班级信息");
        classInfoButton.addActionListener(new
                EduAdminFrame_classInfoButton_actionAdapter(this));
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
        classId.setOpaque(false);
        classId.setEditable(false);
        this.setResizable(false);
        classHQId.setOpaque(false);
        classHQId.setEditable(false);
        classTeacher.setOpaque(false);
        classTeacher.setEditable(false);
        classType.setOpaque(false);
        classType.setEditable(false);

        jMenuFile.setText("系统管理");
        jMenuFileExit.setToolTipText("");
        jMenuFileExit.setText("退出系统");
        jMenuFileExit.addActionListener(new
                                        EduAdminFrame_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setText("帮助");
        jMenuHelpAbout.setText("关于");
        jMenuHelpAbout.addActionListener(new
                                         EduAdminFrame_jMenuHelpAbout_ActionAdapter(this));

        jPanel1.setBackground(new Color(237, 234, 255));
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jMenuItem1.addActionListener(new EduAdminFrame_jMenuItem1_actionAdapter(this));
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jLabel2, new XYConstraints(35, 45, 149, 27));
        jPanel1.add(jLabel1, new XYConstraints(67, 23, 94, 23));
        this.getContentPane().add(tablePanel, java.awt.BorderLayout.CENTER);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton1);
        jScrollPane1.getViewport().add(classTable);
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
        tablePanel.add(exitmanageButton, new XYConstraints(566, 364, 86, 21));
        tablePanel.add(jLabel8, new XYConstraints(580, 210, 45, -1));
        tablePanel.add(jScrollPane1, new XYConstraints(1, 3, 722, 191));
        tablePanel.add(delstuButton, new XYConstraints(236, 365, 68, 20));
        tablePanel.add(modifystuButton, new XYConstraints(320, 365, 68, 20));
        tablePanel.add(savestuButton, new XYConstraints(408, 365, 68, 20));
        tablePanel.add(addstuButton, new XYConstraints(126, 365, 86, 20));
        jPanel2.add(jRadioButton2, new XYConstraints(126, 5, -1, -1));
        jPanel2.add(jRadioButton3, new XYConstraints(201, 5, -1, -1));
        jPanel2.add(jRadioButton1, new XYConstraints(49, 5, -1, -1));
        jPanel1.add(jPanel2, new XYConstraints(261, 18, 267, 67));
        jPanel1.add(classInfoButton, new XYConstraints(570, 46, 91, 19));
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
            this.setTitle(userinfo.getUserId()+"教务管理界面");
            jLabel1.setText(userinfo.getUserId()+"老师");
            if(calendar.get(Calendar.HOUR_OF_DAY)>12){
                jLabel2.setText("下午好!欢迎您使用本系统!");
            }
        }

        //初始化Table表
        public ArrayList initClassTable(){
            String seme="S1";
            switch(flag){
                 case 0:seme="S1";break;
                 case 1:seme="S2";break;
                 case 2:seme="Y2";break;
                 default:seme="S1";
            }
            ClassAction classAction=new ClassAction();
            ArrayList classlist=classAction.findAllClassBySeme(seme);
            DefaultTableModel defaultTableModel1=new DefaultTableModel();
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
            }else{
                System.out.println("error:EduAdminFrame.initClassTable()");
            }
            classTable.setModel((TableModel)defaultTableModel1);
            //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
            //据时以整列为单位.
            classTable.setCellSelectionEnabled(true);

            //取得table的ListSelectionModel.
            selectionMode=classTable.getSelectionModel();
            selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
            classTable.revalidate();
            selectionMode.addListSelectionListener(this);
            return classlist;
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
            if(row<0){
                row=0;
            }
            if(row>=0){
                ClassInfoBean classinfo = (ClassInfoBean) classlist.get(row);
                //给文本框赋值
                classId.setText(classinfo.getClassId());
                classHQId.setText(classinfo.getClassHQId());
                classTeacher.setText(classinfo.getClassTeacher());
                classManager.setText(classinfo.getClassManager());
                classBeginDate.setText(classinfo.getClassBeginDate());
                classDutoEndDate.setText(classinfo.getClassDutoEndDate()); //预计结课日期
                classTestDate.setText(classinfo.getClassTestDate()); //预计参加考试时间
                classType.setText(classinfo.getClassType()); //班级种类
                classWeekTime.setText("" + classinfo.getClassWeekTime()); //周课时数
                classBeginNumber.setText("" + classinfo.getClassBeginNumber()); //开课人数
                classStuIn.setText("" + classinfo.getClassStuIn()); //转入
                classStuOut.setText("" + classinfo.getClassStuOut()); //转出
                classStuPause.setText("" + classinfo.getClassStuPause()); //休学
                classNumber.setText("" + classinfo.getClassNumber()); //班级人数
                classEndDate.setText(classinfo.getClassEndDate()); //结课日期
                classEndNumber.setText("" + classinfo.getClassEndNumber()); //结课时人数
                classGraduRate.setText("" + classinfo.getClassGraduRate()); //预计升学率
                classPassNumber.setText("" + classinfo.getClassPassNumber()); //获证人数
                classGradeNumber.setText("" + classinfo.getClassGradeNumber()); //实际升学人数
                classRealRate.setText("" + classinfo.getClassRealRate()); //实际升学率
                classSeme.setText(classinfo.getClassSeme()); //学期
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

        //单击"S1"单选按钮
        public void jRadioButton1_actionPerformed(ActionEvent e) {
            this.flag=0;
        }

        //单击"S2"单选按钮
        public void jRadioButton2_actionPerformed(ActionEvent e) {
           this.flag=1;
        }

        //单击"Y2"单选按钮
        public void jRadioButton3_actionPerformed(ActionEvent e) {
            this.flag=2;
        }

        //单击"班级信息"按钮
        public void classInfoButton_actionPerformed(ActionEvent e) {
            String seme="S1";
            switch(flag){
                 case 0:seme="S1";break;
                 case 1:seme="S2";break;
                 case 2:seme="Y2";break;
                 default:seme="S1";
            }
            ClassAction classAction=new ClassAction();
            this.classlist=classAction.findAllClassBySeme(seme);
            DefaultTableModel defaultTableModel1=new DefaultTableModel();
            defaultTableModel1.setColumnCount(0);
            defaultTableModel1.setRowCount(0);
            //添加表头
            defaultTableModel1.addColumn("班级编号");
            defaultTableModel1.addColumn("授课教员");
            defaultTableModel1.addColumn("班主任");
            defaultTableModel1.addColumn("开课日期");
            defaultTableModel1.addColumn("班级人数");
            //添加表格内容
            int i=0;
            if(classlist!=null){
                ClassInfoBean classinfo=null;
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
            }else{
                System.out.println("error:显示班级信息时出错！");
            }
            classTable.setModel((TableModel)defaultTableModel1);
            classTable.revalidate();
            //tablePanel.repaint();
            this.repaint();
        }

        //增加一个新的班级
        public void addstuButton_actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            if(e.getActionCommand().equals("增加新班")){
                addstuButton.setText("取消");
                setAllTextFieldEditable(true); //将文本框设置为可编辑
                clearStuInfo(); //首先清空所有文本框
                delstuButton.setEnabled(false); //"删除"按钮失效
                modifystuButton.setEnabled(false); //"修改"按钮失效
                savestuButton.setEnabled(true);
            }else{
                addstuButton.setText("增加新班");
                setAllTextFieldEditable(false); //将文本框设置为不可编辑
                delstuButton.setEnabled(true); //"删除"按钮生效
                modifystuButton.setEnabled(true); //"修改"按钮生效
                savestuButton.setEnabled(false);//"保存"按钮失效
            }
        }

        //设置文本框状态
        public void setAllTextFieldEditable(boolean isEnable){
            classId.setEditable(isEnable);
            classHQId.setEditable(isEnable);
            classTeacher.setEditable(isEnable);
            classManager.setEditable(isEnable);
            classBeginDate.setEditable(isEnable);
            classDutoEndDate.setEditable(isEnable);
            classTestDate.setEditable(isEnable);
            classType.setEditable(isEnable);
            classWeekTime.setEditable(isEnable);
            classBeginNumber.setEditable(isEnable);
            classStuIn.setEditable(isEnable);
            classStuOut.setEditable(isEnable);
            classStuPause.setEditable(isEnable);
            classNumber.setEditable(isEnable);
            classEndDate.setEditable(isEnable);
            classEndNumber.setEditable(isEnable);
            classGraduRate.setEditable(isEnable);
            classPassNumber.setEditable(isEnable);
            classGradeNumber.setEditable(isEnable);
            classRealRate.setEditable(isEnable);
            classSeme.setEditable(isEnable);
        }

        //清空所有文本框
        public void clearStuInfo(){
            classId.setText("");//班级编号
            classHQId.setText("");
            classTeacher.setText("");
            classManager.setText("");
            classBeginDate.setText("");
            classDutoEndDate.setText("");
            classTestDate.setText("");
            classType.setText("");
            classWeekTime.setText("12");
            classBeginNumber.setText("0");
            classStuIn.setText("0");
            classStuOut.setText("0");
            classStuPause.setText("0");
            classNumber.setText("0");
            classEndDate.setText("");
            classEndNumber.setText("0");
            classGraduRate.setText("0.0");
            classPassNumber.setText("0");
            classGradeNumber.setText("0");
            classRealRate.setText("0.0");
            classSeme.setText("");
        }

        //删除班级信息
        public void delstuButton_actionPerformed(ActionEvent e) {
            String classNo=classId.getText().trim();
            if(classNo.equals("")){
                JOptionPane.showMessageDialog(this,"请先选择要删除的班级！","警告",JOptionPane.WARNING_MESSAGE);
                classId.requestFocus();
                return;
            }
            ClassAction classAction=new ClassAction();
            int line=0;
            int result = JOptionPane.showConfirmDialog(this,"您真的要删除此班级信息吗？", "删除确认", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){//选择：Yes or OK
                line=classAction.deleteClass(classNo);//删除班级
                if(line==0)
                    JOptionPane.showMessageDialog(this,"删除失败，请检查！","警告",JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(this,"删除成功！","成功",JOptionPane.WARNING_MESSAGE);
            }//end if

            //重新获取班级信息
            classlist=this.getClassInfo();
            //重新初始化Table表
            this.classlist=initClassTable();
            this.repaint();
        }//end method

        //从班级信息表中获得ArrayList对象
        public ArrayList getClassInfo(){
            String seme="S1";
            switch(flag){
                 case 0:seme="S1";break;
                 case 1:seme="S2";break;
                 case 2:seme="Y2";break;
                 default:seme="S1";
            }
            ArrayList list=new ArrayList();
            ClassAction classAction = new ClassAction();
            list=classAction.findAllClassBySeme(seme);
            return list;
        }

        //修改班级信息
        public void modifystuButton_actionPerformed(ActionEvent e) {
            String classNo=classId.getText().trim();
            if(classNo.equals("")){
                JOptionPane.showMessageDialog(this,"请先选择要修改的班级！","警告",JOptionPane.WARNING_MESSAGE);
                classId.requestFocus();
                return;
            }

            if(e.getActionCommand().equals("修改")){
                modifystuButton.setText("取消");
                setAllTextFieldEditable(true); //将文本框设置为可编辑
                delstuButton.setEnabled(false); //"删除"按钮失效
                addstuButton.setEnabled(false); //"增加"按钮失效
                savestuButton.setEnabled(true);
            }else{
                modifystuButton.setText("修改");
                setAllTextFieldEditable(false); //将文本框设置为晃可编辑
                delstuButton.setEnabled(true); //"删除"按钮生效
                addstuButton.setEnabled(true); //"增加"按钮生效
                savestuButton.setEnabled(false);
            }
        }

        //保存一个新的班级信息
    public void savestuButton_actionPerformed(ActionEvent e) {
        String classNo=classId.getText().trim();
        String classBId=classHQId.getText().trim();
        if(classNo.equals("")){
            JOptionPane.showMessageDialog(this,"班级编号不能为空！","警告",JOptionPane.WARNING_MESSAGE);
            classId.requestFocus();
            return;
        }
        if(classBId.equals("")){
            JOptionPane.showMessageDialog(this,"总部班级编号不能为空！","警告",JOptionPane.WARNING_MESSAGE);
            classHQId.requestFocus();
            return;
        }

        if(addstuButton.isEnabled()){//如果是保存新增加的班级信息,将班级信息同时增加到班级信息表
            ClassInfoBean classinfo=createClass();
            ClassAction classAction=new ClassAction();

            int result=classAction.addClass(classinfo);
            if(result==0){
                JOptionPane.showMessageDialog(this,"添加班级信息失败，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this,"添加新班级信息成功","消息",JOptionPane.INFORMATION_MESSAGE);
                setAllTextFieldEditable(false);//重新将文本框设置为不可编辑
                savestuButton.setEnabled(false);//"保存"按钮失效
                addstuButton.setText("增加新班");
                delstuButton.setEnabled(true);//"删除"按钮生效
                modifystuButton.setEnabled(true);//"修改"按钮生效
            }
        }
        else if(modifystuButton.isEnabled()){//如果是保存修改过的班级信息
            ClassInfoBean classinfo=createClass();
            int result1=new ClassAction().deleteClass(classNo);
            if(result1==0){
                JOptionPane.showMessageDialog(this,"无法修改，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }
            int result2=new ClassAction().addClass(classinfo);
            if(result2==0){
                JOptionPane.showMessageDialog(this,"修改班级信息失败，请检查输入是否正确！","警告",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(this,"修改班级信息成功","消息",JOptionPane.INFORMATION_MESSAGE);
                setAllTextFieldEditable(false);//重新将文本框设置为不可编辑
                savestuButton.setEnabled(false);//"保存"按钮失效
                delstuButton.setEnabled(true);//"删除"按钮生效
                addstuButton.setEnabled(true);//"增加"按钮生效
                modifystuButton.setText("修改");
            }
        }
        //重新初始化Table表
        this.classlist=this.initClassTable();
        classTable.revalidate();
        tablePanel.repaint();
        //this.repaint();
    }

    //将文本框信息封闭到一个ClassInfoBean当中
    public ClassInfoBean createClass(){
        ClassInfoBean classinfo=new ClassInfoBean();
        //获取文本框的值
        classinfo.setClassBeginDate(classBeginDate.getText().trim());
        classinfo.setClassBeginNumber(Integer.parseInt(classBeginNumber.getText().trim()));
        classinfo.setClassDutoEndDate(classDutoEndDate.getText().trim());//姓名
        classinfo.setClassEndDate(classEndDate.getText().trim());//姓名拼音
        classinfo.setClassEndNumber(Integer.parseInt(classEndNumber.getText().trim()));//性别
        classinfo.setClassGradeNumber(Integer.parseInt(classGradeNumber.getText().trim()));//身份证号
        classinfo.setClassGraduRate(Double.parseDouble(classGraduRate.getText().trim()));
        classinfo.setClassHQId(classHQId.getText().trim());
        classinfo.setClassId(classId.getText().trim());
        classinfo.setClassManager(classManager.getText().trim());
        classinfo.setClassNumber(Integer.parseInt(classNumber.getText().trim()));
        classinfo.setClassPassNumber(Integer.parseInt(classPassNumber.getText().trim()));
        classinfo.setClassRealRate(Double.parseDouble(classRealRate.getText().trim()));
        classinfo.setClassSeme(classSeme.getText().trim());
        classinfo.setClassStuIn(Integer.parseInt(classStuIn.getText().trim()));
        classinfo.setClassStuOut(Integer.parseInt(classStuOut.getText().trim()));
        classinfo.setClassStuPause(Integer.parseInt(classStuPause.getText().trim()));
        classinfo.setClassTeacher(classTeacher.getText().trim());
        classinfo.setClassTestDate(classTestDate.getText().trim());
        classinfo.setClassType(classType.getText().trim());
        classinfo.setClassWeekTime(Integer.parseInt(classWeekTime.getText().trim()));

        return classinfo;
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


class EduAdminFrame_jMenuItem1_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_jMenuItem1_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}


class EduAdminFrame_jRadioButton1_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_jRadioButton1_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton1_actionPerformed(e);
    }
}


class EduAdminFrame_jRadioButton3_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_jRadioButton3_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton3_actionPerformed(e);
    }
}


class EduAdminFrame_jRadioButton2_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_jRadioButton2_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton2_actionPerformed(e);
    }
}


class EduAdminFrame_savestuButton_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_savestuButton_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.savestuButton_actionPerformed(e);
    }
}


class EduAdminFrame_jButton3_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_jButton3_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.modifystuButton_actionPerformed(e);
    }
}


class EduAdminFrame_delstuButton_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_delstuButton_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.delstuButton_actionPerformed(e);
    }
}


class EduAdminFrame_addstuButton_actionAdapter implements ActionListener {
    private EduAdminFrame adaptee;
    EduAdminFrame_addstuButton_actionAdapter(EduAdminFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.addstuButton_actionPerformed(e);
    }
}


class EduAdminFrame_classInfoButton_actionAdapter implements ActionListener {
        private EduAdminFrame adaptee;
        EduAdminFrame_classInfoButton_actionAdapter(EduAdminFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            adaptee.classInfoButton_actionPerformed(e);
        }
    }

    class EduAdminFrame_exitmanageButton_actionAdapter implements
            ActionListener {
        private EduAdminFrame adaptee;
        EduAdminFrame_exitmanageButton_actionAdapter(EduAdminFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            adaptee.exitmanageButton_actionPerformed(e);
        }
    }

    class EduAdminFrame_jMenuFileExit_ActionAdapter implements ActionListener {
        EduAdminFrame adaptee;

        EduAdminFrame_jMenuFileExit_ActionAdapter(EduAdminFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            adaptee.jMenuFileExit_actionPerformed(actionEvent);
        }
    }


    class EduAdminFrame_jMenuHelpAbout_ActionAdapter implements ActionListener {
        EduAdminFrame adaptee;

        EduAdminFrame_jMenuHelpAbout_ActionAdapter(EduAdminFrame adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
        }
}
