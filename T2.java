package com.homework;

public class T2 {
    public static void main(String[] args) {
        int a[][]=new int [3][3];
        int b[][]=new int [3][3];
        int c[][]=new int [3][3];

//        给a赋值
        a[0][0]=1;a[0][1]=2;a[0][2]=3;
        a[1][0]=4;a[1][1]=5;a[1][2]=6;
        a[2][0]=7;a[2][1]=8;a[2][2]=9;
//        给b赋值
        b[0][0]=1;b[0][1]=2;b[0][2]=3;
        b[1][0]=4;b[1][1]=5;b[1][2]=6;
        b[2][0]=7;b[2][1]=8;b[2][2]=9;

//        矩阵乘法
        for(int i =0;i<=2;i++){
            for(int j=0;j<=2;j++){
                for(int k=0;k<=2;k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

//        循环输出
        for(int i=0;i<=2;i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(c[i][j]+" ");
                if(j==2){
                    System.out.println();
                }
            }
        }
    }
}
