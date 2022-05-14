package com.com_09_01;

import java.io.*;

//单级文件夹的复制
public class CopyFolderDemo {
    public static void main(String[] args) throws IOException {

        //创建数据源目录File对象，路径是E:\\itcast
        File srcFolder = new File("E:\\itcast");

        //获取数据换目录File对象名称(itcast)
        String srcFolderName = srcFolder.getName();

        //创建目的地目录File对象，路径名是模块名+itcast组成(myCharStream\\itcast)
        File destFolder = new File("myHarStream", srcFolderName);

        //判断目的地目录对应的File是否存在，如果不存在，就创建
        if (!destFolder.exists()) {
            destFolder.mkdir();
        }

        //获取数据源目录下所有文件的File数组
        File[] listFiles = srcFolder.listFiles();

        //便利FIle数组，得到每一个File对象
        for (File srcFile : listFiles) {
            String srcFileName = srcFile.getName();
            File destFile = new File(destFolder, srcFileName);
            copFile(srcFile, destFile);
        }
    }

    private static void copFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1)
            bos.write(bys, 0, len);
        bos.close();
        bis.close();
    }

}
