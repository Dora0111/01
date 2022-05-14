package com.com_09_01;

/*
 * 打印流的特点：
 * 只负责输出数据，不负责读取数据
 * 有自己特有的方法
 *
 * 字节打印流
 * PrintStream(String fileName):使用指定的文件名创建新的打印流
 *
 * 字符打印流
 * Print(String fileName):使用指定的文件名创建一个新的PrintWriter,而不需要自动执行刷新
 * PrintWriter(Writer out ,boolean autoFlush):创建一个新的PrintWriter
 */

import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream("E:\\test_02\\ps.txt");

        //写数据
        //字节输出流有的方法
//        ps.write(97);
        //使用特有的方法
//        ps.println(97);
        //释放资源
//        ps.close();

        //===========================================================
//        PrintWriter pw = new PrintWriter("E:\\test_02\\pw.txt");

//        pw.write("hello");
//        pw.write("\r\n");
//        pw.flush();
//        pw.write("world");
//        pw.write("\r\n");
//        pw.flush();

//        pw.println("我是大帅哥");
//        pw.flush();

        //下面是不需要flush的
        PrintWriter pw = new PrintWriter(new FileWriter("E:\\test_02\\pw.txt"), true);
        pw.println("hello");
        pw.println("da");
    }
}
