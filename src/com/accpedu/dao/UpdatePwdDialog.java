package com.accpedu.dao;

import com.accpedu.model.UserInfoBean;

import java.awt.*;
import javax.swing.*;
//import com.borland.jbcl.layout.XYLayout;
//import com.borland.jbcl.layout.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePwdDialog extends JDialog {
    JPanel panel1 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JPasswordField jPasswordField1 = new JPasswordField();
    JPasswordField jPasswordField2 = new JPasswordField();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JButton jButton1 = new JButton();

    UserInfoBean userinfo=null;
    JButton jButton2 = new JButton();
    GridBagLayout gridBagLayout1 = new GridBagLayout();

    public UpdatePwdDialog(Frame owner, String title, boolean modal, UserInfoBean userinfo) {
        super(owner, title, modal);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        //获得登录的用户信息
        this.userinfo=userinfo;
    }

    public UpdatePwdDialog() {
        this(null, "密码更改对话框", true,null);
    }

    private void jbInit() throws Exception {
        panel1.setLayout(gridBagLayout1);
        panel1.setBackground(new Color(237, 234, 255));
        jLabel1.setText("新 密 码:");
        jLabel2.setText("确认密码:");
        jLabel3.setFont(new java.awt.Font("楷体_GB2312", Font.PLAIN, 20));
        jLabel3.setForeground(Color.red);
        jLabel3.setText("用 户 密 码 更 改");
        jLabel4.setForeground(Color.red);
        jLabel4.setText("请牢记新密码！");
        jButton1.setBackground(new Color(230, 230, 255));
        jButton1.setText("确认更改");
        jButton1.addActionListener(new UpdatePwdDialog_jButton1_actionAdapter(this));
        jPasswordField1.setText("111111");
        jPasswordField2.setText("111111");
        jButton2.setBackground(new Color(230, 230, 255));
        jButton2.setText("关闭");
        jButton2.addActionListener(new UpdatePwdDialog_jButton2_actionAdapter(this));
        getContentPane().add(panel1);
        panel1.add(jLabel3, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(36, 112, 0, 96), 22, 10));
        panel1.add(jLabel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(25, 84, 0, 0), 11, 3));
        panel1.add(jPasswordField1, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(25, 11, 0, 90), 110, -5));
        panel1.add(jLabel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(39, 84, 0, 0), 10, 6));
        panel1.add(jLabel4, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(24, 0, 0, 156), 7, 4));
        panel1.add(jPasswordField2, new GridBagConstraints(1, 2, 2, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(40, 11, 0, 90), 110, -5));
        panel1.add(jButton2, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(21, 45, 44, 90), 26, -7));
        panel1.add(jButton1, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(21, 97, 44, 0), 0, -6));
    }

    //单击"确认按钮"，更改密码
    public void jButton1_actionPerformed(ActionEvent e) {
        String pwd1=new String(jPasswordField1.getPassword());
        String pwd2=new String(jPasswordField2.getPassword());
        if(!pwd1.equals(pwd2)||pwd1.length()==0){
            jLabel4.setText("您两次输入的密码不一致或为空，请重新输入!");
            jPasswordField1.setText("111111");
            jPasswordField2.setText("111111");
            return;
        }
        UserAction userAction=new UserAction();
        int result=userAction.updateUserPwd(userinfo.getUserId(),pwd1);
        if(result!=0){
            JOptionPane.showMessageDialog(this, "密码修改成功！", "消息",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "密码修改失败！", "警告",
                                          JOptionPane.WARNING_MESSAGE);
            return;
        }
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        dispose();
    }

    public void jButton2_actionPerformed(ActionEvent e) {
        dispose();
    }
}


class UpdatePwdDialog_jButton2_actionAdapter implements ActionListener {
    private UpdatePwdDialog adaptee;
    UpdatePwdDialog_jButton2_actionAdapter(UpdatePwdDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}


class UpdatePwdDialog_jButton1_actionAdapter implements ActionListener {
    private UpdatePwdDialog adaptee;
    UpdatePwdDialog_jButton1_actionAdapter(UpdatePwdDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
