package com.accpedu.view;

import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;

import com.accpedu.dao.DepartmentAction;
import com.accpedu.dao.TeacherAction;
import com.accpedu.dao.UpdatePwdDialog;
import com.accpedu.dao.UserAction;
import com.accpedu.model.DepartmentInfoBean;
import com.accpedu.model.TeacherInfoBean;
import com.accpedu.model.UserBean;
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
import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class PresidentFrame extends JFrame{
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    XYLayout xYLayout1 = new XYLayout();
    TitledBorder titledBorder1 = new TitledBorder("");
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel4 = new JLabel();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JPanel tablePanel = new JPanel();
    XYLayout xYLayout2 = new XYLayout();

    JButton roleAssignButton = new JButton();
    JButton okButton = new JButton();
    JButton exitmanageButton = new JButton();
    JLabel jLabel3 = new JLabel();

    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JMenu jMenu1 = new JMenu();
    JMenuItem jMenuItem1 = new JMenuItem();

    DefaultComboBoxModel classModel=new DefaultComboBoxModel();
    ArrayList classlist=new ArrayList();
    UserInfoBean userinfo=null;
    //ClassInfoBean classInfo=null;

    int flag=0;//0:权限未做改动;1:权限做了改动

    JComboBox departComboBox = new JComboBox();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JList jList1 = new JList();
    JLabel jLabel7 = new JLabel();
    JList jList2 = new JList();
    JPanel jPanel2 = new JPanel();
    TitledBorder titledBorder2 = new TitledBorder("");
    JLabel jLabel10 = new JLabel();
    JCheckBox jCheckBox1 = new JCheckBox();
    JCheckBox jCheckBox2 = new JCheckBox();
    JCheckBox jCheckBox3 = new JCheckBox();
    JCheckBox jCheckBox4 = new JCheckBox();
    JCheckBox jCheckBox5 = new JCheckBox();
    JCheckBox jCheckBox6 = new JCheckBox();
    XYLayout xYLayout3 = new XYLayout();

    //部门.
    //hw01:行政部;hw02:市场部;h203:教质部;hw04:学术部;
    //hw05:就业部;hw06:财务部;hw07:后勤部;hw08:人事部;
    String department = "全部"; //默认为学术部
    ArrayList departmentlist = null; //所有部门

    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();

    public PresidentFrame(UserInfoBean user) {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        this.userinfo=user;//将登录用户的信息传递给权限管理窗口

        //设置欢迎词
        sayHello();
        //初始化departComboBox
        this.departmentlist = initDepartComboBox();
    }

    private void jbInit() throws Exception {
        titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(
                EtchedBorder.RAISED, Color.white, new Color(156, 156, 158)),
                                         "角色");
        titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(new
                Color(227, 212, 234), 2), "请选择查看内容");
        getContentPane().setLayout(borderLayout1);
        jPanel1.setLayout(xYLayout1);
        jLabel1.setForeground(Color.red);
        jLabel1.setText("XXX老师");
        jLabel2.setForeground(Color.red);
        jLabel2.setText("上午好!欢迎您使用本系统!");
        jLabel4.setFont(new java.awt.Font("楷体_GB2312", Font.BOLD, 30));
        jLabel4.setText("用 户 权 限 管 理");
        tablePanel.setBackground(new Color(237, 234, 255));
        tablePanel.setMinimumSize(new Dimension(725, 415));
        tablePanel.setPreferredSize(new Dimension(725, 415));
        tablePanel.setLayout(xYLayout2);
        roleAssignButton.setMargin(new Insets(2, 2, 2, 2));
        roleAssignButton.setText("角色分配");
        roleAssignButton.addActionListener(new
                PresidentFrame_roleAssignButton_actionAdapter(this));
        okButton.setEnabled(false);
        okButton.setText("确定");
        okButton.addActionListener(new PresidentFrame_okButton_actionAdapter(this));
        exitmanageButton.setText("退出管理");
        exitmanageButton.addActionListener(new
                PresidentFrame_exitmanageButton_actionAdapter(this));
        jLabel3.setText("    ");
        this.setResizable(false);
        jLabel5.setText("部门:");
        jLabel6.setText("员工:");
        jList1.setBorder(BorderFactory.createEtchedBorder());
        jLabel7.setText("授权用户:");
        jList2.setBorder(BorderFactory.createEtchedBorder());
        jList2.addListSelectionListener(new
                PresidentFrame_jList2_listSelectionAdapter(this));
        jPanel2.setBorder(titledBorder2);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(xYLayout3);
        jLabel10.setText("分配角色:");
        jCheckBox1.setEnabled(false);
        jCheckBox1.setOpaque(false);
        jCheckBox1.setText("班主任");
        jCheckBox1.addActionListener(new
                                     PresidentFrame_jCheckBox1_actionAdapter(this));
        jCheckBox2.setEnabled(false);
        jCheckBox2.setOpaque(false);
        jCheckBox2.setToolTipText("");
        jCheckBox2.setText("教务");
        jCheckBox2.addActionListener(new
                                     PresidentFrame_jCheckBox2_actionAdapter(this));
        jCheckBox3.setEnabled(false);
        jCheckBox3.setOpaque(false);
        jCheckBox3.setText("人事专员");
        jCheckBox3.addActionListener(new
                                     PresidentFrame_jCheckBox3_actionAdapter(this));
        jCheckBox4.setEnabled(false);
        jCheckBox4.setOpaque(false);
        jCheckBox4.setText("就业专员");
        jCheckBox4.addActionListener(new
                                     PresidentFrame_jCheckBox4_actionAdapter(this));
        jCheckBox5.setEnabled(false);
        jCheckBox5.setOpaque(false);
        jCheckBox5.setText("教质经理");
        jCheckBox5.addActionListener(new
                                     PresidentFrame_jCheckBox5_actionAdapter(this));
        jCheckBox6.setEnabled(false);
        jCheckBox6.setOpaque(false);
        jCheckBox6.setText("中心校长");
        jCheckBox6.addActionListener(new
                                     PresidentFrame_jCheckBox6_actionAdapter(this));

        jMenuFile.setText("系统管理");
        jMenuFileExit.setToolTipText("");
        jMenuFileExit.setText("退出系统");
        jMenuFileExit.addActionListener(new
                                        PresidentFrame_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setText("帮助");
        jMenuHelpAbout.setText("关于");
        jMenuHelpAbout.addActionListener(new
                                         PresidentFrame_jMenuHelpAbout_ActionAdapter(this));

        departComboBox.addActionListener(new
                PresidentFrame_departComboBox_actionAdapter(this));
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.setText(">>>>>>>");
        jButton1.addActionListener(new PresidentFrame_jButton1_actionAdapter(this));
        jButton2.setMargin(new Insets(2, 2, 2, 2));
        jButton2.setMnemonic('0');
        jButton2.setText("<<<<<<<");
        jButton2.addActionListener(new PresidentFrame_jButton2_actionAdapter(this));
        jPanel1.setBackground(new Color(237, 234, 255));
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jMenuItem1.addActionListener(new
                                     PresidentFrame_jMenuItem1_actionAdapter(this));
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jLabel2, new XYConstraints(35, 45, 149, 27));
        this.getContentPane().add(tablePanel, java.awt.BorderLayout.CENTER);
        jPanel1.add(jLabel3, new XYConstraints(345, 81, -1, -1));
        tablePanel.add(jList1, new XYConstraints(55, 60, 158, 291));
        tablePanel.add(jLabel5, new XYConstraints(21, 21, 35, 21));
        tablePanel.add(departComboBox, new XYConstraints(54, 22, 160, 18));
        tablePanel.add(jLabel6, new XYConstraints(21, 60, -1, 16));
        jPanel1.add(jLabel1, new XYConstraints(71, 23, 90, 23));
        jPanel1.add(jLabel4, new XYConstraints(293, 35, 290, 38));
        jPanel2.add(jCheckBox1, new XYConstraints(26, 5, -1, -1));
        jPanel2.add(jCheckBox2, new XYConstraints(26, 31, -1, -1));
        jPanel2.add(jCheckBox3, new XYConstraints(26, 57, -1, -1));
        jPanel2.add(jCheckBox4, new XYConstraints(26, 83, -1, -1));
        jPanel2.add(jCheckBox5, new XYConstraints(26, 109, -1, -1));
        jPanel2.add(jCheckBox6, new XYConstraints(26, 135, -1, -1));

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

        tablePanel.add(jLabel10, new XYConstraints(520, 37, 67, 20));
        tablePanel.add(exitmanageButton, new XYConstraints(548, 317, 86, 21));
        tablePanel.add(roleAssignButton, new XYConstraints(517, 279, 68, 20));
        tablePanel.add(okButton, new XYConstraints(594, 279, 68, 20));
        tablePanel.add(jList2, new XYConstraints(304, 60, 156, 291));
        tablePanel.add(jLabel7, new XYConstraints(305, 40, 61, 17));
        tablePanel.add(jButton1, new XYConstraints(219, 125, 78, 18));
        tablePanel.add(jButton2, new XYConstraints(219, 211, 77, 17));
        tablePanel.add(jPanel2, new XYConstraints(519, 60, 138, 189));
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
        this.setTitle(userinfo.getUserId()+"用户权限管理界面");
        jLabel1.setText(userinfo.getUserId()+"校长");
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

    //单击“角色分配”按钮
    public void roleAssignButton_actionPerformed(ActionEvent e) {
        int leftselected = jList2.getSelectedIndex();
        //如果没有在右边选择用户
        if (leftselected < 0) {
            JOptionPane.showMessageDialog(this, "请先选择要管理的用户", "警告",
                                              JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(roleAssignButton.getText().trim().equals("角色分配")){
            //将角色复选框设为可编辑
            jCheckBox1.setEnabled(true);
            jCheckBox2.setEnabled(true);
            jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);
            jCheckBox5.setEnabled(true);
            jCheckBox6.setEnabled(true);
            //将“角色分配”按钮设为“取消”
            roleAssignButton.setText("取消");
            //将“确定”按钮设为可用
            okButton.setEnabled(true);
        }else{
            //将角色复选框设为不可编辑
            jCheckBox1.setEnabled(false);
            jCheckBox2.setEnabled(false);
            jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);
            jCheckBox5.setEnabled(false);
            jCheckBox6.setEnabled(false);
            //将“取消”按钮设为“角色分配”
            roleAssignButton.setText("角色分配");
            //将“确定”按钮设为不可用
            okButton.setEnabled(false);
        }
    }

    //单击"确定"按钮
    public void okButton_actionPerformed(ActionEvent e) {
        //将角色复选框设为不可编辑
        jCheckBox1.setEnabled(false);
        jCheckBox2.setEnabled(false);
        jCheckBox3.setEnabled(false);
        jCheckBox4.setEnabled(false);
        jCheckBox5.setEnabled(false);
        jCheckBox6.setEnabled(false);
        //将“取消”按钮设为“角色分配”
        roleAssignButton.setText("角色分配");
        //将“确定”按钮设为不可用
        okButton.setEnabled(false);
        //修改用户权限
        if(this.flag==1){
            updateUserRole();
            this.flag=0;
        }
    }

    //更新用户权限
    public void updateUserRole(){
        int leftselected = jList2.getSelectedIndex();
        //如果没有在左边选择用户
        if (leftselected < 0) {
            JOptionPane.showMessageDialog(this, "请先在左边选择要管理的用户", "警告",
                                              JOptionPane.WARNING_MESSAGE);
            return;
        }
        //获得要更改权限的用户的id
        ArrayList list = getUserTeacherInfo();
        TeacherInfoBean teacher = (TeacherInfoBean) list.get(leftselected);
        String userid=teacher.getTeacherId();
        //获得用户新的权限
        String userRole="";
        if(jCheckBox1.isSelected())  userRole=userRole+"D";//班主任
        if(jCheckBox2.isSelected())  userRole=userRole+"E";//教务
        if(jCheckBox3.isSelected())  userRole=userRole+"C";//人事
        if(jCheckBox4.isSelected())  userRole=userRole+"F";//就业
        if(jCheckBox5.isSelected())  userRole=userRole+"B";//教质经理
        if(jCheckBox6.isSelected())  userRole=userRole+"A";//中心校长
        //更新用户表中的用户权限
        UserAction userAction = new UserAction();
        int result = userAction.updateUserRole(userid,userRole);
        if (result == 0) {
            JOptionPane.showMessageDialog(this, "操作失败", "警告",
                                              JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(this, "操作成功", "好消息",
                                              JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //单击"部门"下拉列表，选择部门
    public void departComboBox_actionPerformed(ActionEvent e) {
        fillJList();
    }

    //填充两个列表
    public void fillJList(){
        ArrayList list1=this.getNonUserTeacherInfo();//非注册用户
        ArrayList list2=this.getUserTeacherInfo();//注册用户
        Iterator it1=list1.iterator();
        Iterator it2=list2.iterator();
        DefaultListModel listModel1=new DefaultListModel();
        DefaultListModel listModel2=new DefaultListModel();
        while(it1.hasNext()){
            TeacherInfoBean teacher=(TeacherInfoBean)it1.next();
            listModel1.addElement(teacher.getTeacherName());
        }
        while(it2.hasNext()){
            TeacherInfoBean teacher=(TeacherInfoBean)it2.next();
            listModel2.addElement(teacher.getTeacherName());
        }
        jList1.setModel(listModel1);
        jList2.setModel(listModel2);
    }
    //从员工信息表中获得非用户员工信息ArrayList对象
    public ArrayList getNonUserTeacherInfo(){
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
        list=teacherAction.findNonUserTeachersByDepart(department);
        return list;
     }

     //从员工信息表中获得已经是用户的员工信息ArrayList对象
    public ArrayList getUserTeacherInfo(){
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
        list=teacherAction.findUserTeachersByDepart(department);
        return list;
     }

    //将左边列表中选中的员工加到右边的用户列表当中
    public void jButton1_actionPerformed(ActionEvent e) {
        int leftselected=jList1.getSelectedIndex();
        String tname=(String)jList1.getSelectedValue();
        System.out.println("teachername="+tname);
        //如果没有在左边选择员工，是无法添加到右边的用户表当中的
        if(leftselected<0){
            JOptionPane.showMessageDialog(this,"请先在左边选择要添加的员工","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        //同时，在角色表当中添加一个用户
        ArrayList list=getNonUserTeacherInfo();
        TeacherInfoBean teacher=(TeacherInfoBean)list.get(leftselected);
        UserAction userAction=new UserAction();
        int result=userAction.addUser(teacher.getTeacherId());
        if(result==0){
            JOptionPane.showMessageDialog(this,"添加用户失败","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            //重新填充两个列表
            fillJList();
        }
    }//end method

    //将右边选中的用户从列表当中删除
    public void jButton2_actionPerformed(ActionEvent e) {
        int confirm = JOptionPane.showConfirmDialog(this,"删除此用户会同时撤销已经分配给此用户的所有权限。\n您真的要删除此用户吗？", "删除确认", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION){//选择：Yes or OK
            int leftselected = jList2.getSelectedIndex();
            String tname = (String) jList2.getSelectedValue();
            System.out.println("username=" + tname);
            //如果没有在右边选择用户
            if (leftselected < 0) {
                JOptionPane.showMessageDialog(this, "请先在右边选择要移除的用户", "警告",
                                              JOptionPane.WARNING_MESSAGE);
                return;
            }
            //同时，在角色表当中删除一个用户
            ArrayList list = getUserTeacherInfo();
            TeacherInfoBean teacher = (TeacherInfoBean) list.get(leftselected);
            UserAction userAction = new UserAction();
            int result = userAction.delUser(teacher.getTeacherId());
            if (result == 0) {
                JOptionPane.showMessageDialog(this, "删除用户失败", "警告",
                                              JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                //重新填充两个列表
                fillJList();
            }
        }
    }//end method

    //在用户列表中选择用户，同时在角色分配栏中显示已经分配的角色
    public void jList2_valueChanged(ListSelectionEvent e) {
        int leftselected = jList2.getSelectedIndex();
        String tname = (String) jList2.getSelectedValue();
        System.out.println("username=" + tname);
        if(leftselected<0){
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            jCheckBox5.setSelected(false);
            jCheckBox6.setSelected(false);
            return;
        }
        ArrayList list = getUserTeacherInfo();
        TeacherInfoBean teacher = (TeacherInfoBean) list.get(leftselected);
        String userId=teacher.getTeacherId();
        UserAction userAction=new UserAction();
        UserBean user=userAction.getUser(userId);
        String userRole=user.getUserRole();
        if(userRole.indexOf("A")==-1){//校长
            jCheckBox6.setSelected(false);
        }else{
            jCheckBox6.setSelected(true);
        }
        if(userRole.indexOf("B")==-1){//部门经理
            jCheckBox5.setSelected(false);
        }else{
            jCheckBox5.setSelected(true);
        }
        if(userRole.indexOf("C")==-1){//人事专员
            jCheckBox3.setSelected(false);
        }else{
            jCheckBox3.setSelected(true);
        }
        if(userRole.indexOf("D")==-1){//班主任
            jCheckBox1.setSelected(false);
        }else{
            jCheckBox1.setSelected(true);
        }
        if(userRole.indexOf("E")==-1){//教务
            jCheckBox2.setSelected(false);
        }else{
            jCheckBox2.setSelected(true);
        }
        if(userRole.indexOf("F")==-1){//就业专员
            jCheckBox4.setSelected(false);
        }else{
            jCheckBox4.setSelected(true);
        }
    }

    public void jCheckBox1_actionPerformed(ActionEvent e) {
        this.flag=1;
    }

    public void jCheckBox2_actionPerformed(ActionEvent e) {
        this.flag=1;
    }

    public void jCheckBox3_actionPerformed(ActionEvent e) {
        this.flag=1;
    }

    public void jCheckBox4_actionPerformed(ActionEvent e) {
        this.flag=1;
    }

    public void jCheckBox5_actionPerformed(ActionEvent e) {
        this.flag=1;
    }

    public void jCheckBox6_actionPerformed(ActionEvent e) {
        this.flag=1;
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


class PresidentFrame_jMenuItem1_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jMenuItem1_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}


class PresidentFrame_exitmanageButton_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_exitmanageButton_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.exitmanageButton_actionPerformed(e);
    }
}


class PresidentFrame_jCheckBox6_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jCheckBox6_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jCheckBox6_actionPerformed(e);
    }
}


class PresidentFrame_jCheckBox5_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jCheckBox5_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jCheckBox5_actionPerformed(e);
    }
}


class PresidentFrame_jCheckBox4_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jCheckBox4_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jCheckBox4_actionPerformed(e);
    }
}


class PresidentFrame_jCheckBox3_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jCheckBox3_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jCheckBox3_actionPerformed(e);
    }
}


class PresidentFrame_jCheckBox2_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jCheckBox2_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jCheckBox2_actionPerformed(e);
    }
}


class PresidentFrame_jCheckBox1_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jCheckBox1_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jCheckBox1_actionPerformed(e);
    }
}


class PresidentFrame_jList2_listSelectionAdapter implements
        ListSelectionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jList2_listSelectionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void valueChanged(ListSelectionEvent e) {
        adaptee.jList2_valueChanged(e);
    }
}


class PresidentFrame_jButton2_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jButton2_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}


class PresidentFrame_jButton1_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_jButton1_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}


class PresidentFrame_departComboBox_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_departComboBox_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.departComboBox_actionPerformed(e);
    }
}


class PresidentFrame_okButton_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_okButton_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.okButton_actionPerformed(e);
    }
}


class PresidentFrame_roleAssignButton_actionAdapter implements ActionListener {
    private PresidentFrame adaptee;
    PresidentFrame_roleAssignButton_actionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.roleAssignButton_actionPerformed(e);
    }
}

class PresidentFrame_jMenuFileExit_ActionAdapter implements ActionListener {
    PresidentFrame adaptee;

    PresidentFrame_jMenuFileExit_ActionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class PresidentFrame_jMenuHelpAbout_ActionAdapter implements ActionListener {
    PresidentFrame adaptee;

    PresidentFrame_jMenuHelpAbout_ActionAdapter(PresidentFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}
