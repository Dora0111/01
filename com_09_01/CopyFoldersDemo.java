package com.com_09_01;

import java.io.*;

import static com.sun.deploy.cache.Cache.copyFile;

public class CopyFoldersDemo {
    public static void main(String[] args) throws IOException {
        //创建数据源File对象，路径是E:\\itcast
        File srcFile =new File("E:\\itcast");
        //创建目的地File对象，路径是F:\\
        File destFile = new File("F:\\");

        //写方法实现文件夹得复制，参数为数据源File对象和目的地File对象
        copyFolder(srcFile, destFile);
    }

    //复制文件夹
    private static void copyFolder(File srcFile, File destFile) throws IOException {
        //判断数据源File是否是目录
        if (srcFile.isDirectory()) {
            String srcFileName= srcFile.getName();
            File newFolder = new File(destFile, srcFileName);
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            //获取数据源File夏所有文件或者目录的File数组
            File[] fileArray = srcFile.listFiles();
            //遍历该File数组，得到每一个File对象
            for (File file : fileArray) {
                copyFolder(file,newFolder);
            }
        }else{
            //说明是文件，直接复制，用字节流
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }

    private static void copFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))) {
            byte[] bys = new byte[1024];
            int len;
            while ((len = bis.read(bys)) != -1)
                bos.write(bys, 0, len);
            bos.close();
        }
        bis.close();
    }
}
