package com.accpedu.view;

import com.accpedu.dao.UpdatePwdDialog;
import com.accpedu.model.UserInfoBean;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class MenuBar {
    JFrame frame = null;
    UserInfoBean userinfo = null;

    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JMenu jMenuPwd = new JMenu();
    JMenuItem jMenuResetPwd = new JMenuItem();

    public MenuBar(JFrame frame,UserInfoBean userinfo) {
        this.frame = frame;
        this.userinfo = userinfo;

        jMenuFile.setText("系统管理");
        jMenuFileExit.setText("退出系统");
        jMenuFileExit.addActionListener(new
                                        Frame_jMenuFileExit_ActionAdapter());
        jMenuFile.add(jMenuFileExit);

        jMenuHelp.setText("帮助");
        jMenuHelpAbout.setText("关于");
        jMenuHelpAbout.addActionListener(new
                                         Frame_jMenuHelpAbout_ActionAdapter(frame));
        jMenuHelp.add(jMenuHelpAbout);

        jMenuPwd.setText("密码维护");
        jMenuResetPwd.setText("更改密码");
        jMenuResetPwd.addActionListener(new Frame_jMenuResetPwd_actionAdapter(frame,userinfo));
        jMenuPwd.add(jMenuResetPwd);

        jMenuBar1.setBackground(new Color(237, 234, 255));
        jMenuBar1.setBorder(BorderFactory.createEtchedBorder());
        jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenuPwd);
        jMenuBar1.add(jMenuHelp);
    }

    public JMenuBar createMenuBar(){
        return this.jMenuBar1;
    }
}

class Frame_jMenuFileExit_ActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
}

class Frame_jMenuResetPwd_actionAdapter implements ActionListener {
    private JFrame adaptee;
    private UserInfoBean userinfo;
    Frame_jMenuResetPwd_actionAdapter(JFrame adaptee, UserInfoBean userinfo) {
        this.adaptee = adaptee;
        this.userinfo = userinfo;
    }

    //单击“修改密码”菜单
    public void actionPerformed(ActionEvent e) {
        UpdatePwdDialog dlg = new UpdatePwdDialog(adaptee,"修改密码",true,userinfo);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = adaptee.getSize();
        Point loc = adaptee.getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.setVisible(true);

    }
}

class Frame_jMenuHelpAbout_ActionAdapter implements ActionListener {
    JFrame adaptee;

    Frame_jMenuHelpAbout_ActionAdapter(JFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        AboutBox dlg = new AboutBox(adaptee);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = adaptee.getSize();
        Point loc = adaptee.getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.setVisible(true);
    }
}
