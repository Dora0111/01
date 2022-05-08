package com.homework;

public class T1 {
    public static void main(String[] args) {
//        要开放的数
        double n = 5.0;
//        将for开方的结果和开方函数的结果相比较
        System.out.print("用开方函数：");
        System.out.println(Math.sqrt(n));
        System.out.print("用for开方：");
        System.out.println(mathSqrt(n));
    }

    public static double mathSqrt(double n){
        //精确到哪一位
        double m=0.000000001;
        double res;
        double i;
        for(i=2.0;i<n;i+=m){
            res=i*i;
            double leave=n-m;
            if((res<=5+2*m)&&(res>=leave)){
//                退出循环
                break;
            }
        }
//        返回i值
        return i;
    }
}
