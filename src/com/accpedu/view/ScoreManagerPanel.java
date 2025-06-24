package com.accpedu.view;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

import com.accpedu.dao.ScoreAction;
import com.accpedu.dao.StudentAction;
import com.accpedu.dao.SubjectAction;
import com.accpedu.model.ClassInfoBean;
import com.accpedu.model.ScoreBean;
import com.accpedu.model.StuInfoBean;
import com.accpedu.model.SubjectBean;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ScoreManagerPanel extends JPanel  implements ListSelectionListener{
    XYLayout xYLayout1 = new XYLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable scoreTable = new JTable();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JComboBox subjectComboBox = new JComboBox();
    JButton okButton = new JButton();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JTextField stuNoTextField = new JTextField();
    JTextField stuNameTextField = new JTextField();
    JTextField subjectTextField = new JTextField();
    JTextField scoreTextField = new JTextField();
    JButton scoreInputButton = new JButton();
    JLabel jLabel8 = new JLabel();
    JPanel jPanel1 = new JPanel();
    TitledBorder titledBorder1 = new TitledBorder("");
    XYLayout xYLayout2 = new XYLayout();
    JRadioButton jRadioButton1 = new JRadioButton();
    JComboBox singleComboBox = new JComboBox();
    JLabel jLabel9 = new JLabel();
    JRadioButton jRadioButton2 = new JRadioButton();
    JButton jButton2 = new JButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();

    ClassInfoBean classinfo=null;//班级信息
    DefaultComboBoxModel subjectComboBoxModel=new DefaultComboBoxModel();
    ListSelectionModel selectionMode=null;
    JComboBox stuNoComboBox = new JComboBox();
    JLabel jLabel10 = new JLabel();

    public ScoreManagerPanel(ClassInfoBean classinfo) {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        this.classinfo=classinfo;//将班级信息传递过来
        subjectComboBoxModel.addElement("------请选择您要科目------");
        initSubjectComboBox(this.classinfo.getClassSeme());//初始化科目选择下拉列表
        initStuNoComboBox(this.classinfo.getClassId());//初始化查询面板当中，“根据学号查询成绩”下拉列表当中的学生学号
    }

    private void jbInit() throws Exception {
        titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(Color.
                pink, 2), "查询成绩");
        this.setLayout(xYLayout1);
        this.setBackground(new Color(237, 234, 255));
        this.setMinimumSize(new Dimension(725, 510));
        this.setPreferredSize(new Dimension(725, 510));
        jScrollPane1.getViewport().setBackground(Color.lightGray);
        scoreTable.setMaximumSize(new Dimension(500, 500));
        scoreTable.setMinimumSize(new Dimension(100, 80));
        scoreTable.setPreferredSize(new Dimension(50, 380));
        jLabel1.setForeground(UIManager.getColor("TitledBorder.titleColor"));
        jLabel1.setText("-----------------------选择科目--------------------");
        jLabel2.setText("科目:");
        okButton.setText("确  定");
        okButton.addActionListener(new ScoreManagerPanel_okButton_actionAdapter(this));
        jLabel3.setForeground(UIManager.getColor("TitledBorder.titleColor"));
        jLabel3.setText("-----------------------成绩录入--------------------");
        jLabel4.setText("学号:");
        jLabel5.setText("姓名:");
        jLabel6.setText("科目:");
        jLabel7.setText("成绩:");
        stuNoTextField.setOpaque(false);
        stuNoTextField.setEditable(false);
        stuNameTextField.setOpaque(false);
        stuNameTextField.setEditable(false);
        subjectTextField.setOpaque(false);
        subjectTextField.setEditable(false);
        scoreInputButton.setEnabled(false);
        scoreInputButton.setText("录  入");
        scoreInputButton.addActionListener(new
                ScoreManagerPanel_scoreInputButton_actionAdapter(this));
        jLabel8.setForeground(UIManager.getColor("TitledBorder.titleColor"));
        jLabel8.setText("--------------------------------------------------");
        jPanel1.setBackground(new Color(168, 219, 255));
        jPanel1.setBorder(titledBorder1);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(xYLayout2);
        jRadioButton1.setOpaque(false);
        jRadioButton1.setToolTipText("");
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("按单科成绩查询");
        jRadioButton1.addActionListener(new
                ScoreManagerPanel_jRadioButton1_actionAdapter(this));
        jLabel9.setText("科目:");
        jRadioButton2.setOpaque(false);
        jRadioButton2.setText("按学号查询成绩");
        jRadioButton2.addActionListener(new
                ScoreManagerPanel_jRadioButton2_actionAdapter(this));
        jButton2.setText("开始查询");
        jButton2.addActionListener(new ScoreManagerPanel_jButton2_actionAdapter(this));
        scoreTextField.setOpaque(false);
        scoreTextField.setEditable(false);
        jLabel10.setText("学号:");
        stuNoComboBox.setEnabled(false);
        stuNoComboBox.setOpaque(false);
        singleComboBox.setOpaque(false);
        jScrollPane1.getViewport().add(scoreTable);
        this.add(okButton, new XYConstraints(112, 102, 90, 21));
        this.add(jLabel2, new XYConstraints(37, 67, 35, 21));
        this.add(jLabel4, new XYConstraints(37, 187, -1, -1));
        this.add(jLabel7, new XYConstraints(37, 293, -1, -1));
        this.add(stuNoTextField, new XYConstraints(74, 184, 163, 19));
        this.add(jLabel5, new XYConstraints(37, 222, -1, -1));
        this.add(jLabel6, new XYConstraints(37, 258, -1, -1));
        this.add(scoreTextField, new XYConstraints(74, 290, 163, -1));
        this.add(stuNameTextField, new XYConstraints(74, 219, 163, -1));
        this.add(subjectTextField, new XYConstraints(74, 255, 163, -1));
        this.add(jLabel8, new XYConstraints(9, 376, 295, -1));
        this.add(jPanel1, new XYConstraints(35, 401, 655, 88));
        jPanel1.add(jRadioButton1, new XYConstraints(32, 6, 112, 18));
        jPanel1.add(jLabel9, new XYConstraints(54, 30, 37, 21));
        this.add(jScrollPane1, new XYConstraints(314, 3, 400, 385));
        this.add(subjectComboBox, new XYConstraints(74, 66, 197, 21));
        this.add(scoreInputButton, new XYConstraints(112, 329, 89, 22));
        this.add(jLabel3, new XYConstraints(13, 148, 258, -1));
        this.add(jLabel1, new XYConstraints(16, 29, 298, 13));
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        jPanel1.add(singleComboBox, new XYConstraints(89, 32, 149, 19));
        jPanel1.add(jRadioButton2, new XYConstraints(292, 1, -1, -1));
        jPanel1.add(jLabel10, new XYConstraints(305, 31, -1, 21));
        jPanel1.add(stuNoComboBox, new XYConstraints(335, 32, 131, 19));
        jPanel1.add(jButton2, new XYConstraints(514, 19, 94, -1));
    }

    //初始化科目选择下拉列表
    public void initSubjectComboBox(String classSeme){
        SubjectAction subjectAction=new SubjectAction();
        ArrayList subjectList=subjectAction.getAllSubjectInfo(classSeme);
        Iterator it=subjectList.iterator();
        while(it.hasNext()){
            subjectComboBoxModel.addElement(((SubjectBean)it.next()).getSubjectName());
        }
        this.subjectComboBox.setModel(this.subjectComboBoxModel);
        this.singleComboBox.setModel(this.subjectComboBoxModel);
    }

    //初始化查询面板当中，“根据学号查询成绩”下拉列表当中的学生学号
    public void initStuNoComboBox(String classNo){
        DefaultComboBoxModel stuNoComboBoxModel=new DefaultComboBoxModel();
        stuNoComboBoxModel.addElement("----请选择学号----");
        StudentAction stuAction=new StudentAction();
        ArrayList stuList=stuAction.findStudentsByClassId(classNo);
        Iterator it=stuList.iterator();
        while(it.hasNext()){
            stuNoComboBoxModel.addElement(((StuInfoBean)it.next()).getStuNo());
        }
        this.stuNoComboBox.setModel(stuNoComboBoxModel);
    }

    //单击“确定”按钮，开始按科目显示成绩，并准备录入
    public void okButton_actionPerformed(ActionEvent e) {
        DefaultTableModel defaultTableModel=null;
        int selectedSubject=subjectComboBox.getSelectedIndex();//选择第几个科目
        if(selectedSubject==0){
            JOptionPane.showMessageDialog(this,"请先选择要操作的科目","警告",JOptionPane.WARNING_MESSAGE);
            subjectComboBox.requestFocus();
            return;
        }
        this.scoreTextField.setEditable(true);
        this.scoreInputButton.setEnabled(true);
        TableFactory tableFactory=new TableFactory(this.classinfo,selectedSubject);
        defaultTableModel=tableFactory.getTableModel();
        this.scoreTable.setModel((TableModel)defaultTableModel);

        //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
        //据时以整列为单位.
        scoreTable.setCellSelectionEnabled(true);

        //取得table的ListSelectionModel.
        selectionMode=scoreTable.getSelectionModel();
        selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
        scoreTable.revalidate();
        selectionMode.addListSelectionListener(this);

        this.repaint();
    }

    //表格选取响应事件
    /*当用户选取表格数据时会触发ListSelectionEvent,
    * 我们实现ListSelectionListener界面来处理这一事件.ListSelectionListener界
    * 面只定义一个方法,那就是valueChanged().
    */
    public void valueChanged(ListSelectionEvent e) {
        String[] score=new String[4];

        int row=scoreTable.getSelectedRow();

        if(row>=0){
            for (int j = 0; j < scoreTable.getColumnCount(); j++) {
                score[j]=(String)scoreTable.getValueAt(row,j);
            }
            //给文本框赋值
            stuNoTextField.setText(score[0]);
            stuNameTextField.setText(score[1]);
            subjectTextField.setText(score[2]);
            scoreTextField.setText(score[3]);
        }
    }

    //单击“录入”按钮，将更改过的成绩录入数据表
    public void scoreInputButton_actionPerformed(ActionEvent e) {
        String classSeme=classinfo.getClassSeme();
        SubjectAction subjectAction=new SubjectAction();
        SubjectBean subjectBean=null;
        ArrayList subjectList=subjectAction.getAllSubjectInfo(classSeme);
        Iterator it=subjectList.iterator();
        while(it.hasNext()){
            subjectBean=(SubjectBean)it.next();
            if(subjectBean.getSubjectName().equals(subjectTextField.getText())){
                break;
            }
        }
        String subjectNo=subjectBean.getSubjectNo();
        ScoreBean scoreBean=new ScoreBean();
        scoreBean.setStuNo(stuNoTextField.getText().trim());
        scoreBean.setSubjectNo(subjectNo);
        scoreBean.setScore(Integer.parseInt(scoreTextField.getText().trim()));
        ScoreAction scoreAction=new ScoreAction();
        int result=scoreAction.updateStudentScore(scoreBean);
        if(result==0){//如果更新失败
            JOptionPane.showMessageDialog(this,"录入新的成绩操作失败，请检查成绩格式是否正确！","警告",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"操作成功","成功",JOptionPane.WARNING_MESSAGE);
        }
    }

    //成绩查询
    public void jButton2_actionPerformed(ActionEvent e) {
        this.scoreTextField.setEditable(false);
        this.scoreInputButton.setEnabled(false);
        //如果是按单科查询成绩
        if(jRadioButton1.isSelected()){
            DefaultTableModel defaultTableModel=null;
            int selectedSubject=singleComboBox.getSelectedIndex();//选择第几个科目
            if(selectedSubject==0){
                JOptionPane.showMessageDialog(this,"请先选择要操作的科目","警告",JOptionPane.WARNING_MESSAGE);
                singleComboBox.requestFocus();
                return;
            }
            TableFactory tableFactory=new TableFactory(this.classinfo,selectedSubject);
            defaultTableModel=tableFactory.getTableModel();
            this.scoreTable.setModel((TableModel)defaultTableModel);

            //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
            //据时以整列为单位.
            scoreTable.setCellSelectionEnabled(true);

            //取得table的ListSelectionModel.
            selectionMode=scoreTable.getSelectionModel();
            selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
            scoreTable.revalidate();
            selectionMode.addListSelectionListener(this);

            this.repaint();
        }
        //如果是查询全部成绩
        else if(jRadioButton2.isSelected()){
            DefaultTableModel defaultTableModel=null;
            int selectedStuno=stuNoComboBox.getSelectedIndex();//选择第几个科目
            String selectedStuNo=(String)stuNoComboBox.getSelectedItem();
            if(selectedStuno==0){
                JOptionPane.showMessageDialog(this,"请先选择要操作的科目","警告",JOptionPane.WARNING_MESSAGE);
                stuNoComboBox.requestFocus();
                return;
            }
            TableFactory tableFactory=new TableFactory(this.classinfo,selectedStuno);
            defaultTableModel=tableFactory.getTableModelByStuNo(selectedStuNo);
            this.scoreTable.setModel((TableModel)defaultTableModel);

            //使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
            //据时以整列为单位.
            scoreTable.setCellSelectionEnabled(true);

            //取得table的ListSelectionModel.
            selectionMode=scoreTable.getSelectionModel();
            selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
            scoreTable.revalidate();
            selectionMode.addListSelectionListener(this);

            this.repaint();
        }
    }

    public void jRadioButton1_actionPerformed(ActionEvent e) {
        if(this.stuNoComboBox.isEnabled()==true){
            this.stuNoComboBox.setEnabled(false);
        }
        if(this.singleComboBox.isEnabled()==false){
            this.singleComboBox.setEnabled(true);
        }
    }

    public void jRadioButton2_actionPerformed(ActionEvent e) {
        if(this.singleComboBox.isEnabled()){
            this.singleComboBox.setEnabled(false);
        }
        if(this.stuNoComboBox.isEnabled()==false){
            this.stuNoComboBox.setEnabled(true);
        }
    }
}


class ScoreManagerPanel_jRadioButton2_actionAdapter implements ActionListener {
    private ScoreManagerPanel adaptee;
    ScoreManagerPanel_jRadioButton2_actionAdapter(ScoreManagerPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton2_actionPerformed(e);
    }
}


class ScoreManagerPanel_jRadioButton1_actionAdapter implements ActionListener {
    private ScoreManagerPanel adaptee;
    ScoreManagerPanel_jRadioButton1_actionAdapter(ScoreManagerPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRadioButton1_actionPerformed(e);
    }
}


class ScoreManagerPanel_scoreInputButton_actionAdapter implements
        ActionListener {
    private ScoreManagerPanel adaptee;
    ScoreManagerPanel_scoreInputButton_actionAdapter(ScoreManagerPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.scoreInputButton_actionPerformed(e);
    }
}


class ScoreManagerPanel_okButton_actionAdapter implements ActionListener {
    private ScoreManagerPanel adaptee;
    ScoreManagerPanel_okButton_actionAdapter(ScoreManagerPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.okButton_actionPerformed(e);
    }
}


class ScoreManagerPanel_jButton2_actionAdapter implements ActionListener {
    private ScoreManagerPanel adaptee;
    ScoreManagerPanel_jButton2_actionAdapter(ScoreManagerPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}
