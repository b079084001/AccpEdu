package com.accpedu.view;

import java.awt.*;
import javax.swing.*;

import com.accpedu.dao.StudentAction;
import com.accpedu.dao.TimeCheckAction;
import com.accpedu.model.ClassInfoBean;
import com.accpedu.model.StuInfoBean;
import com.accpedu.model.TimeCheckBean;
import com.borland.jbcl.layout.XYLayout;
import javax.swing.table.TableModel;
import com.borland.jbcl.layout.XYConstraints;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import java.util.Iterator;
import java.awt.Dimension;
import java.text.DateFormat;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCheckPanel2 extends JPanel implements ListSelectionListener{
    XYLayout xYLayout1 = new XYLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateFormatter df = new DateFormatter(format);
    JFormattedTextField jFormattedTextField1 = new JFormattedTextField(df);

    JButton jButton1 = new JButton();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JComboBox jComboBox1 = new JComboBox();
    JButton inputButton = new JButton();
    JLabel jLabel7 = new JLabel();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JRadioButton jRadioButton1 = new JRadioButton();
    JRadioButton jRadioButton2 = new JRadioButton();
    JButton jButton3 = new JButton();
    JTable timeCheckTable = new JTable();

    ClassInfoBean classinfo=null;
    ListSelectionModel selectionMode=null;
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JComboBox jComboBox2 = new JComboBox();
    JComboBox jComboBox3 = new JComboBox();

    public TimeCheckPanel2(ClassInfoBean classinfo) {
      try {
          jbInit();
      } catch (Exception exception) {
          exception.printStackTrace();
      }
      this.classinfo=classinfo;
      //初始化考勤状况下拉列表
      initTimeCheckState();
      //初始化按日期查询下拉列表
      initSelectByDate();
      //初始化按学号查询下拉列表
      initSelectByStuid();
    }

    private void jbInit() throws Exception {
        this.setBackground(new Color(237, 234, 255));
        this.setLayout(xYLayout1);
        jLabel1.setForeground(Color.red);
        jLabel1.setText("-----------请输入考勤日期---------");
        jLabel2.setText("考勤日期:");
        jFormattedTextField1.setText("jFormattedTextField1");
        jFormattedTextField1.setValue(new Date());
        jFormattedTextField1.setEnabled(false);
        jButton1.setEnabled(false);
        jButton1.setText("确  定");
        jButton1.addActionListener(new TimeCheckPanel2_jButton1_actionAdapter(this));
        jLabel3.setForeground(Color.red);
        jLabel3.setText("--------------考勤录入------------");
        jLabel4.setText("学号:");
        jLabel5.setText("姓名:");
        jLabel6.setText("考勤:");
        jTextField1.setEnabled(false);
        jTextField1.setOpaque(false);
        jTextField1.setEditable(false);
        jTextField2.setEnabled(false);
        jTextField2.setOpaque(false);
        jTextField2.setEditable(false);
        jComboBox1.setEnabled(false);
        inputButton.setEnabled(false);
        inputButton.setText("录  入");
        inputButton.addActionListener(new
                                      TimeCheckPanel2_inputButton_actionAdapter(this));
        jLabel7.setForeground(Color.red);
        jLabel7.setText("---------------考勤查询-------------");
        jRadioButton1.setOpaque(false);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("按日期查询");
        jRadioButton1.addActionListener(new
                TimeCheckPanel2_jRadioButton1_actionAdapter(this));
        jRadioButton2.setOpaque(false);
        jRadioButton2.setText("按学号查询");
        jRadioButton2.addActionListener(new
                TimeCheckPanel2_jRadioButton2_actionAdapter(this));
        jButton3.setText("查询考勤");
        jButton3.addActionListener(new TimeCheckPanel2_jButton3_actionAdapter(this));
        timeCheckTable.setMaximumSize(new Dimension(1000, 1000));
        timeCheckTable.setMinimumSize(new Dimension(100, 100));
        timeCheckTable.setPreferredSize(new Dimension(100, 480));
        jLabel8.setText("日期:");
        jLabel9.setText("学号:");
        jComboBox3.setEnabled(false);
        xYLayout1.setWidth(720);
        xYLayout1.setHeight(492);

        jScrollPane1.getViewport().add(timeCheckTable);
        this.add(jLabel1, new XYConstraints(24, 21, 214, 16));
        this.add(jLabel2, new XYConstraints(21, 54, 57, 22));
        this.add(jLabel3, new XYConstraints(24, 131, 208, 18));
        this.add(jButton1, new XYConstraints(85, 89, 86, 19));
        this.add(jLabel4, new XYConstraints(47, 162, 32, 19));
        this.add(jLabel5, new XYConstraints(47, 196, 32, 19));
        this.add(jLabel6, new XYConstraints(47, 233, 32, 19));
        this.add(jComboBox1, new XYConstraints(80, 231, 114, 20));
        this.add(inputButton, new XYConstraints(84, 270, 85, 19));
        this.add(jFormattedTextField1, new XYConstraints(77, 56, 116, 19));
        this.add(jTextField1, new XYConstraints(81, 161, 113, 19));
        this.add(jTextField2, new XYConstraints(81, 196, 113, 18));
        this.add(jLabel8, new XYConstraints(66, 365, 35, 17));
        this.add(jComboBox2, new XYConstraints(98, 364, 102, 18));
        this.add(jLabel9, new XYConstraints(66, 419, 35, 17));
        this.add(jComboBox3, new XYConstraints(98, 418, 102, 18));
        this.add(jRadioButton2, new XYConstraints(43, 392, -1, -1));
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        this.add(jScrollPane1, new XYConstraints(238, 5, 464, 472));
        this.add(jLabel7, new XYConstraints(21, 310, 214, -1));
        this.add(jButton3, new XYConstraints(71, 453, 104, 20));
        this.add(jRadioButton1, new XYConstraints(43, 338, 110, -1));
    }

    //初始化考勤状况下拉列表
    public void initTimeCheckState(){
        DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
        String[] states={"出勤","迟到","请假","旷课","早退"};
        for(int i=0;i<4;i++){
            comboBoxModel.addElement(states[i]);
        }
        jComboBox1.setModel(comboBoxModel);
    }
    //初始化按日期查询下拉列表
    public void initSelectByDate(){
        TimeCheckAction timeCheckAction=new TimeCheckAction();
        String classid=classinfo.getClassId();
        System.out.println("classid="+classid);
        ArrayList list=timeCheckAction.getCheckTime(classid);
        Iterator it=list.iterator();
        DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
        while(it.hasNext()){
            comboBoxModel.addElement(it.next().toString());
        }
        jComboBox2.setModel(comboBoxModel);
    }

    //初始化按学号查询下拉列表
    public void initSelectByStuid(){
        StudentAction stuAction=new StudentAction();
        ArrayList list=stuAction.findStudentsByClassId(classinfo.getClassId());
        Iterator it=list.iterator();
        DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
        StuInfoBean stuInfoBean=null;
        while(it.hasNext()){
            stuInfoBean=(StuInfoBean)it.next();
            comboBoxModel.addElement(stuInfoBean.getStuNo());
        }
        jComboBox3.setModel(comboBoxModel);
    }

    //表格选取响应事件
    /*当用户选取表格数据时会触发ListSelectionEvent,
    * 我们实现ListSelectionListener界面来处理这一事件.ListSelectionListener界
    * 面只定义一个方法,那就是valueChanged().
    */
    public void valueChanged(ListSelectionEvent e) {
        String[] score=new String[3];

        int row=timeCheckTable.getSelectedRow();

        if(row>=0){
            for (int j = 0; j < timeCheckTable.getColumnCount()-1; j++) {
                score[j]=(String)timeCheckTable.getValueAt(row,j);
            }
            //int selected=0;//"出勤","迟到","请假","旷课","早退"
           // if(score[2].equals("迟到")) selected=1;
           // else if(score[2].equals("请假")) selected=2;
           // else if(score[2].equals("旷课")) selected=3;
           // else if(score[2].equals("早退")) selected=4;
            //给文本框赋值
            jTextField1.setText(score[0]);
            jTextField2.setText(score[1]);
            this.jComboBox1.getModel().setSelectedItem(score[2]);
        }
    }

    //单击“确定”按钮，将初始学员考勤信息插入考勤表
    public void jButton1_actionPerformed(ActionEvent e) {
        if(jComboBox1.isEnabled()==false){
            this.jComboBox1.setEnabled(true);
        }
        if(inputButton.isEnabled()==false){
            this.inputButton.setEnabled(true);
        }
        //先判断此日期的考勤在数据库当中有没有
        String timeCheckDate=jFormattedTextField1.getText().trim();
        System.out.println("timeCheckDate="+timeCheckDate);
        TimeCheckAction timeCheckAction=new TimeCheckAction();
        boolean flag=timeCheckAction.checkTimeCheckDate(timeCheckDate);
        System.out.println("flag="+flag);
        if(flag){//说明此为一新的考勤,需要在考勤表中插入这一天的记录
            StudentAction studentAction=new StudentAction();
            ArrayList stuList=studentAction.findStudentsByClassId(this.classinfo.getClassId());
            ArrayList timeCheckList=new ArrayList();
            Iterator it=stuList.iterator();
            while(it.hasNext()){
                TimeCheckBean timeCheckBean=new TimeCheckBean();
                StuInfoBean stu=(StuInfoBean)it.next();
                timeCheckBean.setStuid(stu.getStuNo());
                timeCheckBean.setCheckedDate(timeCheckDate);
                timeCheckList.add(timeCheckBean);
            }
            timeCheckAction.addNewTimeCheck(timeCheckList);
        }
        //else{
        //    JOptionPane.showMessageDialog(this,"请先选择要操作的科目","警告",JOptionPane.WARNING_MESSAGE);
        //}
        DefaultTableModel defaultTableModel=null;
        TableFactory tableFactory=new TableFactory(this.classinfo,1);
        defaultTableModel=tableFactory.getTableModelByTimeCheckDate(timeCheckDate);
        this.timeCheckTable.setModel((TableModel)defaultTableModel);

        //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
        //据时以整列为单位.
        timeCheckTable.setCellSelectionEnabled(true);

        //取得table的ListSelectionModel.
        selectionMode=timeCheckTable.getSelectionModel();
        selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
        timeCheckTable.revalidate();
        selectionMode.addListSelectionListener(this);

        this.initSelectByDate();
        this.initSelectByStuid();

        this.repaint();
    }

    //录入新的考勤信息
    public void inputButton_actionPerformed(ActionEvent e) {
        String timeCheckState;
        if(jComboBox1.getSelectedItem()!=null){
            timeCheckState = ((String) jComboBox1.getSelectedItem()). trim();
        }
        else{
            return;
        }
        TimeCheckAction timeCheckAction=new TimeCheckAction();
        TimeCheckBean timeCheckBean=new TimeCheckBean();
        timeCheckBean.setStuid(jTextField1.getText().trim());//设置学号
        System.out.println("timeCheckState="+timeCheckState);
        timeCheckBean.setCheckedState(timeCheckState);//设置出勤状态
        timeCheckBean.setCheckedDate(jFormattedTextField1.getText().trim());//设置考勤时间
        timeCheckAction.updateTimeCheck(timeCheckBean);

        //更新表格
        String timeCheckDate=jFormattedTextField1.getText().trim();
        DefaultTableModel defaultTableModel=null;
        TableFactory tableFactory=new TableFactory(this.classinfo,1);
        defaultTableModel=tableFactory.getTableModelByTimeCheckDate(timeCheckDate);
        this.timeCheckTable.setModel((TableModel)defaultTableModel);
        timeCheckTable.revalidate();
        this.repaint();
    }

    public void jButton3_actionPerformed(ActionEvent e) {
        if(jComboBox1.isEnabled()){
            jComboBox1.setEnabled(false);
        }
        if(inputButton.isEnabled()){
            inputButton.setEnabled(false);
        }

        TableFactory tableFactory=new TableFactory(this.classinfo,1);
        //如果是按日期查询考勤信息
        if(jRadioButton1.isSelected()){
            String timeCheckDate;
            if(jComboBox2.getSelectedItem()!=null){
                timeCheckDate = (String) jComboBox2.getSelectedItem();
                timeCheckDate = timeCheckDate.trim();
            }else{return;}

            DefaultTableModel defaultTableModel=null;
            defaultTableModel=tableFactory.getTableModelByTimeCheckDate(timeCheckDate);
            this.timeCheckTable.setModel((TableModel)defaultTableModel);

            //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
            //据时以整列为单位.
            //timeCheckTable.setCellSelectionEnabled(true);

            //取得table的ListSelectionModel.
            //selectionMode=timeCheckTable.getSelectionModel();
            //selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
            timeCheckTable.revalidate();
            //selectionMode.addListSelectionListener(this);
            this.repaint();
        }
        //如果是按学员考员查询考勤信息
        else if(jRadioButton2.isSelected()){
            String stuid;
            if(jComboBox3.getSelectedItem()!=null){
                stuid = (String) jComboBox3.getSelectedItem();
                stuid = stuid.trim();
            }else{return;}
            DefaultTableModel defaultTableModel=null;
            defaultTableModel=tableFactory.getTableModelByStuid(stuid);
            this.timeCheckTable.setModel((TableModel)defaultTableModel);

            //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
            //据时以整列为单位.
            //timeCheckTable.setCellSelectionEnabled(true);

            //取得table的ListSelectionModel.
            //selectionMode=timeCheckTable.getSelectionModel();
            //selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
            timeCheckTable.revalidate();
            //selectionMode.addListSelectionListener(this);
            this.repaint();
        }
    }

    public void jRadioButton1_actionPerformed(ActionEvent e) {
        if(jComboBox2.isEnabled()==false){
            jComboBox2.setEnabled(true);
        }
        if(jComboBox3.isEnabled()){
            jComboBox3.setEnabled(false);
        }
    }//end

    public void jRadioButton2_actionPerformed(ActionEvent e) {
        if(jComboBox3.isEnabled()==false){
            jComboBox3.setEnabled(true);
        }
        if(jComboBox2.isEnabled()){
            jComboBox2.setEnabled(false);
        }
    }//end
}


class TimeCheckPanel2_jRadioButton2_actionAdapter implements ActionListener {
    private TimeCheckPanel2 adaptee;
    TimeCheckPanel2_jRadioButton2_actionAdapter(TimeCheckPanel2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton2_actionPerformed(e);
    }
}


class TimeCheckPanel2_jRadioButton1_actionAdapter implements ActionListener {
    private TimeCheckPanel2 adaptee;
    TimeCheckPanel2_jRadioButton1_actionAdapter(TimeCheckPanel2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton1_actionPerformed(e);
    }
}

class TimeCheckPanel2_inputButton_actionAdapter implements ActionListener {
    private TimeCheckPanel2 adaptee;
    TimeCheckPanel2_inputButton_actionAdapter(TimeCheckPanel2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.inputButton_actionPerformed(e);
    }
}

class TimeCheckPanel2_jButton3_actionAdapter implements ActionListener {
    private TimeCheckPanel2 adaptee;
    TimeCheckPanel2_jButton3_actionAdapter(TimeCheckPanel2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton3_actionPerformed(e);
    }
}


class TimeCheckPanel2_jButton1_actionAdapter implements ActionListener {
    private TimeCheckPanel2 adaptee;
    TimeCheckPanel2_jButton1_actionAdapter(TimeCheckPanel2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
