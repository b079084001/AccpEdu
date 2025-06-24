package com.accpedu.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
////import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Dimension;
//import java.awt.BorderLayout;
import com.accpedu.dao.LoginAction;
import com.accpedu.model.UserInfoBean;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
//import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.Box;
//import javax.swing.UIManager;
//import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * <p>Title: 教务管理系统</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: zzhw</p>
 *
 * @author
 * @version 1.0
 */
public class LoginFrame extends JFrame {
    JPanel contentPane;
    XYLayout xYLayout1 = new XYLayout();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JTextField userName = new JTextField();
    JComboBox roleName = new JComboBox();
    DefaultComboBoxModel roleModel=new DefaultComboBoxModel();
    JButton loginButton = new JButton();
    JButton resetButton = new JButton();
    JButton exitButton = new JButton();
    JPasswordField passWord = new JPasswordField();
    JLabel infoLabel = new JLabel();
    JLabel warnLabel = new JLabel();
    ImageIcon image1 = new ImageIcon();
    ImageIcon image2 = new ImageIcon();
    ImageIcon image3 = new ImageIcon();
    ImageIcon image4 = new ImageIcon();
    ImageIcon image5 = new ImageIcon();
    JPanel jPanel1 = new JPanel();
    JLabel jLabel6 = new JLabel();
    XYLayout xYLayout2 = new XYLayout();

    public LoginFrame() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        image1 = createImageIcon("images/butffler.jpg");
        image2 = createImageIcon("images/username.gif");
        image3 = createImageIcon("images/password.gif");
        image4 = createImageIcon("images/warning.gif");
        image5 = createImageIcon("images/role2.jpg");
        //image1 = new ImageIcon(accpedu.LoginFrame.class.getResource("butffler.jpg"));
        //image2 = new ImageIcon(accpedu.LoginFrame.class.getResource("username.gif"));
        //image3 = new ImageIcon(accpedu.LoginFrame.class.getResource("password.gif"));
        //image4 = new ImageIcon(accpedu.LoginFrame.class.getResource("warning.gif"));
        //image5 = new ImageIcon(accpedu.LoginFrame.class.getResource("role2.jpg"));
        jLabel6.setIcon(image1);
        jLabel3.setIcon(image2);
        jLabel4.setIcon(image3);
        warnLabel.setIcon(image4);
        jLabel5.setIcon(image5);
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(xYLayout2);
        this.getContentPane().setBackground(new Color(237, 234, 255));
        setSize(new Dimension(592, 401));
        setTitle("教务管理系统");
        jLabel1.setText("");
        jLabel2.setFont(new java.awt.Font("隶书", Font.PLAIN, 36));
        jLabel2.setText("教 务 管 理 系 统");
        jLabel3.setText("账 号:");
        jLabel4.setText("密 码:");
        jLabel5.setText("角 色:");
        loginButton.setBackground(new Color(205, 220, 255));
        loginButton.setOpaque(false);
        loginButton.setText("登  录");
        loginButton.addActionListener(new LoginFrame_jButton1_actionAdapter(this));
        resetButton.setBackground(new Color(205, 220, 255));
        resetButton.setOpaque(false);
        resetButton.setText("重 置");
        resetButton.addActionListener(new LoginFrame_resetButton_actionAdapter(this));
        exitButton.setBackground(new Color(205, 220, 250));
        exitButton.setOpaque(false);
        exitButton.setMargin(new Insets(2, 2, 2, 2));
        exitButton.setText("退出系统");
        exitButton.addActionListener(new LoginFrame_exitButton_actionAdapter(this));
        infoLabel.setText("请输入账号和密码登录！");
        warnLabel.setText("提 示:");
        jPanel1.setBackground(new Color(183, 197, 0));
        jPanel1.setPreferredSize(new Dimension(200, 10));
        jPanel1.setBounds(100,100,200,5);
        roleName.setOpaque(false);
        roleModel.addElement("--请选择您登录的角色--");
        roleModel.addElement("班 主 任");
        roleModel.addElement("教务专员");
        roleModel.addElement("人事专员");
        roleModel.addElement("就业专员");
        roleModel.addElement("教质经理");
        roleModel.addElement("中心校长");
        roleName.setModel(roleModel);
        contentPane.setMinimumSize(new Dimension(581, 390));
        contentPane.setPreferredSize(new Dimension(581, 400));
        contentPane.add(exitButton, new XYConstraints(379, 322, 80, 22));
        contentPane.add(resetButton, new XYConstraints(261, 322, 66, 22));
        contentPane.add(loginButton, new XYConstraints(142, 322, -1, 22));
        contentPane.add(roleName, new XYConstraints(201, 261, 240, 20));
        contentPane.add(jLabel5, new XYConstraints(145, 262, -1, -1));
        contentPane.add(passWord, new XYConstraints(201, 213, 240, -1));
        contentPane.add(jLabel4, new XYConstraints(145, 210, -1, 30));
        contentPane.add(userName, new XYConstraints(201, 166, 239, 24));
        contentPane.add(jLabel3, new XYConstraints(145, 166, -1, 25));
        contentPane.add(infoLabel, new XYConstraints(201, 127, 262, 21));
        contentPane.add(warnLabel, new XYConstraints(144, 127, -1, 21));
        contentPane.add(jLabel2, new XYConstraints(142, 47, 322, 40));
        contentPane.add(jLabel6, new XYConstraints(482, 18, 99, 67));
        contentPane.add(jLabel1, new XYConstraints(263, 26, 72, 21));
        contentPane.add(jPanel1, new XYConstraints(30, 93, 530, 2));
    }

    /**返回一个ImageIcon对象,如果文件路径无效，则返回null. */
    public ImageIcon createImageIcon(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.err.println("找不到文件: " + path);
        }
        if(img != null){
            return new ImageIcon(img);
        }else{
            return null;
        }
    }

    public void resetButton_actionPerformed(ActionEvent actionEvent) {
        warnLabel.setText("提示：");
        infoLabel.setText("请输入账号和密码登录！");
        userName.setText("");
        passWord.setText("");
        roleName.setSelectedIndex(0);
    }

    public void loginButton_actionPerformed(ActionEvent actionEvent) {
        String roleid="";
        int roleselected=roleName.getSelectedIndex();
        if(roleselected==0){    //如果没有选择角色
            warnLabel.setForeground(Color.RED);
            warnLabel.setText("警告：");
            infoLabel.setForeground(Color.RED);
            infoLabel.setText("您没有选择合适的角色，请选择后登录！");
            roleName.requestFocus();//角色选择框获得输入焦点
            return;
        }
        System.out.println("roleselected="+roleselected);
        switch(roleselected){
            case 1:
                roleid="%D%";
                break;//班主任登录,账号:301a004
            case 2:
                roleid="%E%";
                break;//教务专员登录,账号:301a008
            case 3:
                roleid="%C%";
                break;//人事专员登录，账号:301a009
            case 4:
                roleid="%F%";
                break;//就业专员登录,账号:301a006
            case 5:
                roleid="%B%";
                break;//部门经理登录,账号:301a003
            case 6:
                roleid="%A%";
                break;//中心校长登录,账号:301a007
        }
        //第一步：创建一个bean，封装登录信息：
        //用户名（userid:301A007),密码(userpwd:111111),用户角色(roleid:A)
        String userPwd=new String(this.passWord.getPassword());
        UserInfoBean user=new UserInfoBean();
        user.setUserId(this.userName.getText());
        user.setUserPwd(userPwd);
        user.setRoleId(roleid);
        LoginAction loginAction=new LoginAction();
        user=loginAction.verify(user);
        if(user!=null){ //如果用户验证通过
            if(userPwd.equals("111111")){
                JOptionPane.showMessageDialog(this, "为了安全，请及时更改原始密码！", "警告",
                                              JOptionPane.WARNING_MESSAGE);
            }
            infoLabel.setText("OK,您已通过验证！");
            //根据用户的角色，打开不同的管理界面
            switch(roleselected){
                case 1://如果是班主任登录
                    openClassManagerWindow(user);
                    break;
                case 2:
                    //如果是教务专员登录
                    openEduAdminWindow(user);
                    break;
                case 3:
                    //如果是人事专员登录
                    openHRWindow(user);
                    break;
                case 4:
                    //如果是就业专员登录
                    openJobWindow(user);
                    break;
                case 5:
                    //如果是部门经理登录
                    openDepartmentManagerWindow(user);
                    break;
                case 6:
                    //如果是校长登录
                    openPresidentManagerWindow(user);
                    break;
             }
        }
        else{//如果用户不合法
            warnLabel.setForeground(Color.RED);
            warnLabel.setText("警告：");
            infoLabel.setForeground(Color.RED);
            infoLabel.setText("您的账号或密码或角色选择不正确！");
            userName.requestFocus();//用户账号文本框获得输入焦点
            userName.setSelectionColor(new Color(200,200,230));
            userName.selectAll();//设置文本框选中
            passWord.setText("");
        }
    }//end loginButton_actionPerformed()

    //打开班主任登录窗口
    public void openClassManagerWindow(UserInfoBean user){
       ClassManagerFrame classManagerFrame = new ClassManagerFrame(user);
       classManagerFrame.pack();
       // Center the window
       centerWindow(classManagerFrame);
   }

   //打开教务专员登录窗口
    public void openEduAdminWindow(UserInfoBean user){
       EduAdminFrame eduAdminFrame = new EduAdminFrame(user);
       eduAdminFrame.pack();
       // Center the window
       centerWindow(eduAdminFrame);
   }

   //打开人事专员登录窗口
    public void openHRWindow(UserInfoBean user){
       HRFrame hrFrame = new HRFrame(user);
       hrFrame.pack();
       // Center the window
       centerWindow(hrFrame);
   }

   //打开就业专员登录窗口
    public void openJobWindow(UserInfoBean user){
       JobFrame jobFrame = new JobFrame(user);
       jobFrame.pack();
       // Center the window
       centerWindow(jobFrame);
   }

   //打开部门经理登录窗口
    public void openDepartmentManagerWindow(UserInfoBean user){
       DepartmentManagerFrame departmentManagerFrame = new DepartmentManagerFrame(user);
       departmentManagerFrame.pack();
       // Center the window
       centerWindow(departmentManagerFrame);
   }

   //打开校长登录窗口
    public void openPresidentManagerWindow(UserInfoBean user){
       PresidentFrame presidentFrame = new PresidentFrame(user);
       presidentFrame.pack();
       // Center the window
       centerWindow(presidentFrame);
   }//end

   // 将窗体居中显示
   public void centerWindow(JFrame frame){
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = frame.getSize();
      if (frameSize.height > screenSize.height) {
           frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
           frameSize.width = screenSize.width;
      }
      frame.setLocation((screenSize.width - frameSize.width) / 2,
                         (screenSize.height - frameSize.height) / 2-50);

      frame.setVisible(true);				//显示窗体
      this.setVisible(false);					//当前登录窗体隐藏
      this.invalidate();
   }

    public void exitButton_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}


class LoginFrame_exitButton_actionAdapter implements ActionListener {
    private LoginFrame adaptee;
    LoginFrame_exitButton_actionAdapter(LoginFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.exitButton_actionPerformed(e);
    }
}


class LoginFrame_jButton1_actionAdapter implements ActionListener {
    private LoginFrame adaptee;
    LoginFrame_jButton1_actionAdapter(LoginFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.loginButton_actionPerformed(actionEvent);
    }
}


class LoginFrame_resetButton_actionAdapter implements ActionListener {
    private LoginFrame adaptee;
    LoginFrame_resetButton_actionAdapter(LoginFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.resetButton_actionPerformed(actionEvent);
    }
}
