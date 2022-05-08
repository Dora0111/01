package com.homework.T4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball {
    //frame对象
    private Frame frame = new Frame("网球小游戏");
    //frame宽度
    private int tableWidth = 500;
    //frame高度
    private int tableHeighi = 350;
    //球大小
    private int ballSize = 20;
    //底座高度 宽度
    private int racketHeight = 10;
    private int racketWidth = 120;
    //小球的坐标
    private int ballx = 160;
    private int bally = 30;
    //定义变量，分别记录小球在x和y方向上移动的v
    private int speedy = 13;
    private int speedx = 8;
    //定义变量，记录球拍的坐标
    private int racketx = 100;
    private int rackety = 300;
    //判断当前游戏是否已结束
    private boolean aBoolean = false;
    private Timer timer;

    private class mycanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (aBoolean) {
                //游戏结束怎么显示
                g.setColor(Color.RED);
                g.setFont(new Font("宋体", Font.BOLD, 30));
                g.drawString("Game Over!", 150, 200);
            } else {
                //小球
                g.setColor(Color.BLACK);
                g.fillOval(ballx, bally, ballSize, ballSize);
                //球拍
                g.setColor(Color.BLACK);
                g.fillRect(racketx, rackety, racketWidth, racketHeight);
            }
        }
    }

    KeyListener listener = new KeyAdapter() {
        //重写
        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_LEFT) {
                if (racketx > 0) {
                    racketx -= 10;
                }
            }
            if (code == KeyEvent.VK_RIGHT) {
                if (racketx < (tableWidth - racketWidth)) {
                    racketx += 10;
                }
            }
        }
    };

    mycanvas canvas = new mycanvas();
    public void init() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.addKeyListener(listener);
        canvas.addKeyListener(listener);
        //小球坐标
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ballx <= 0 || ballx >= (tableWidth - ballSize)) {
                    speedx = -speedx;
                }
                if (bally <= 0 || (bally > rackety - ballSize && ballx > racketx && ballx < racketx + racketWidth)) {
                    speedy = -speedy;
                }
                if (bally > rackety - ballSize && (ballx < racketx || ballx > racketx + racketWidth)) {
                    timer.stop();
                    aBoolean = true;
                    canvas.repaint();
                }
                ballx += speedx;
                bally += speedy;
                canvas.repaint();
            }
        };
        timer = new Timer(90, listener);
        timer.start();
        canvas.setPreferredSize(new Dimension(tableWidth, tableHeighi));
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

}

