package com.dong;

import java.util.Scanner;

/**
 * Autor : dong
 * Time:2018/12/12
 */
public class CheckRunNian {
    public static boolean isRunNian(int year) {
        //boolean isTrue =false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份：");
        int in = scanner.nextInt();
        boolean a = isRunNian(in);
        System.out.println(a);
    }

}
