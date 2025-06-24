package com.accpedu.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import java.awt.Font;

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
public class AboutBox extends JDialog implements ActionListener {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel insetsPanel1 = new JPanel();
    JPanel insetsPanel2 = new JPanel();
    JPanel insetsPanel3 = new JPanel();
    JButton button1 = new JButton();
    JLabel imageLabel = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    ImageIcon image1 = new ImageIcon();
    BorderLayout borderLayout2 = new BorderLayout();
    FlowLayout flowLayout1 = new FlowLayout();
    GridLayout gridLayout1 = new GridLayout();
    String product = "教务管理系统";
    String version = "1.0";
    String copyright = "Copyright (c) 2008";
    String comments = "";
    JLabel jLabel1 = new JLabel();
    XYLayout xYLayout1 = new XYLayout();

    public AboutBox(Frame parent) {
        super(parent);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public AboutBox() {
        this(null);
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        image1 = new ImageIcon(LoginFrame.class.getResource("about.png"));
        imageLabel.setIcon(image1);
        setTitle("About");
        panel1.setLayout(xYLayout1);
        panel2.setLayout(borderLayout2);
        insetsPanel1.setLayout(flowLayout1);
        insetsPanel2.setLayout(flowLayout1);
        insetsPanel2.setBackground(new Color(237, 234, 255));
        insetsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridLayout1.setRows(4);
        gridLayout1.setColumns(1);
        label1.setText(product);
        label2.setText(version);
        label3.setText(copyright);
        insetsPanel3.setLayout(gridLayout1);
        insetsPanel3.setBackground(new Color(237, 234, 255));
        insetsPanel3.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 10));
        button1.setBackground(new Color(230, 230, 255));
        button1.setText("OK");
        button1.addActionListener(this);
        insetsPanel1.setBackground(new Color(237, 234, 255));
        panel1.setBackground(new Color(237, 234, 255));
        jLabel1.setFont(new java.awt.Font("隶书", Font.PLAIN, 20));
        jLabel1.setForeground(new Color(219, 0, 0));
        jLabel1.setText("作者：xxx    问题反馈:132000000000");
        panel2.setBackground(new Color(237, 234, 255));
        insetsPanel2.add(imageLabel, null);
        panel1.add(label1, new XYConstraints(120, 74, -1, -1));
        panel2.add(insetsPanel2, BorderLayout.WEST);
        getContentPane().add(panel1, null);
        insetsPanel3.add(label2, null);
        insetsPanel3.add(label3, null);
        panel1.add(insetsPanel1, new XYConstraints(0, 219, 400, 81));
        insetsPanel1.add(button1, null);
        panel1.add(jLabel1, new XYConstraints(12, 188, 372, 31));
        panel1.add(panel2, new XYConstraints(0, 0, 400, 75));
        panel1.add(insetsPanel3, new XYConstraints(64, 93, -1, 95));
        setResizable(true);
    }

    /**
     * Close the dialog on a button event.
     *
     * @param actionEvent ActionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button1) {
            dispose();
        }
    }
}
