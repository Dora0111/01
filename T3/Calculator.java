package com.homework.T3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

public class Calculator {

    private JFrame frame;
    private JTextField jTextField;
    private JButton[] jButtons;
    private JPanel jPanel;
    private boolean iLF;
    private double l, r;
    private String pre = "";
    private String data = "";

    public void init() {
        setFrame();
        setTextField();
        setButton();
        displayFrame();
    }

    //    设置frame
    private void setFrame() {
        frame = new JFrame();
//        frame的标题
        frame.setTitle("                       超级计算器");
//        frame的大小
        frame.setSize(500, 600);
//        frame的坐标
        frame.setLocation(650, 200);
//        设置布局
        frame.setLayout(null);
    }

    //        设置文本域
    private void setTextField() {
        jTextField = new JTextField("0");
//        文本框大小位置
        jTextField.setBounds(20, 15, 450, 60);
//        文本框字体
        jTextField.setFont(new Font("宋体", Font.BOLD, 35));
//        背景颜色
        jTextField.setBackground(new Color(250, 250, 250));
        frame.add(jTextField);
    }

    //      设置按键
    private void setButton() {
        String[] arr = {" ", "C", "CE", "/", "7", "8", "9", "*", "4", "5", "6", "+", "1", "2", "3", "-", "+/-", "0", ".", "=",};
        jButtons = new JButton[arr.length];
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5, 4, 8, 8));
        jPanel.setBounds(40, 90, 400, 450);

        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(arr[i]);
            jButtons[i].setFont(new Font("宋体", Font.CENTER_BASELINE, 25));
            jButtons[i].setBackground(new Color(250, 240, 250));
            int idex = i;
            jButtons[i].addMouseListener(new MouseAdapter() {
//                重写
                @Override
                public void mouseClicked(MouseEvent e) {
//                    获取内容
                    click(jButtons[idex].getText());
                }
            });
//             添加按钮
            jPanel.add(jButtons[i]);
        }

        frame.add(jPanel);
    }

    public void click(String s) {
        String s1;

        if ("1".equals(s)) {
            data += "1";
            jTextField.setText(data);
        } else if ("2".equals(s)) {
            data += "2";
            jTextField.setText(data);
        } else if ("3".equals(s)) {
            data += "3";
            jTextField.setText(data);
        } else if ("4".equals(s)) {
            data += "4";
            jTextField.setText(data);
        } else if ("5".equals(s)) {
            data += "5";
            jTextField.setText(data);
        } else if ("6".equals(s)) {
            data += "6";
            jTextField.setText(data);
        } else if ("7".equals(s)) {
            data += "7";
            jTextField.setText(data);
        } else if ("8".equals(s)) {
            data += "8";
            jTextField.setText(data);
        } else if ("9".equals(s)) {
            data += "9";
            jTextField.setText(data);
        } else if ("0".equals(s)) {
            data += "0";
            jTextField.setText(data);
        } else if (".".equals(s)) {
            data += ".";
            jTextField.setText(data);
        } else if ("+/-".equals(s)) {
            if (data.indexOf('-') < 0) {
                data = "-" + data;
            }
            // 负数
            else {
                data = data.substring(1);
            }
            jTextField.setText(data);
        } else if ("%".equals(s)) {
            data = Double.parseDouble(data) / 100 + "";
            jTextField.setText(data);
        } else if ("+".equals(s)) {
            s1 = "+";
            cal(s1);
        } else if ("-".equals(s)) {
            s1 = "-";
            cal(s1);
        } else if ("*".equals(s)) {
            s1 = "*";
            cal(s1);
        } else if ("/".equals(s)) {
            s1 = "/";
            cal(s1);
        } else if ("=".equals(s)) {
            s1 = "=";
            cal(s1);
        } else if ("CE".equals(s)) {
            if (data.length() != 0) {
                data = data.substring(0, data.length() - 1);
            }
            jTextField.setText(data);
        } else if ("C".equals(s)) {
            data = "";
            iLF = false;
            jTextField.setText(data);
        }
    }

    private String textFormat(String s) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String result = numberFormat.format(Double.parseDouble(s));
        return result;
    }

    public void displayFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void cal(String s) {
        if ("".equals(data)) {
            if ("=".equals(s)) {
                iLF = false;
            }
            return;
        }
        if (iLF) {
            r = Double.parseDouble(data);
            data = "";

            // 使用前一个运算符
            if ("+".equals(pre)) {
                l += r;
            } else if ("-".equals(pre)) {
                l -= r;
            } else if ("*".equals(pre)) {
                l *= r;
            } else if ("/".equals(pre)) {
                l /= r;
            }
            if (l == (int) l) {
                l = (int) l;
            }
        } else {
            l = Double.parseDouble(data);
            data = "";
            iLF = true;
        }
        String result = l + "";
        if ("=".equals(s)) {
            iLF = false;
        }
        pre = s;
        jTextField.setText(textFormat(result) + " " + s);
    }
}
