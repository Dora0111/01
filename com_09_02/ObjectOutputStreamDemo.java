package com.com_09_02;

import java.io.*;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\test_02\\oss.txt"));
        Student s = new Student("林青霞", 30);
        oos.writeObject(s);
        oos.close();
    }
}
