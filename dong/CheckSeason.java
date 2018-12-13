package com.dong;

import java.util.Scanner;

/**
 * Autor : dong
 * Time:2018/12/12
 */
public class CheckSeason {
    public static void main(String[] args) {
        String season = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个月份：");
        //int month = scanner.nextInt();
        while (true) {
            int month = scanner.nextInt();
            if (month > 0 && month < 13) {
                switch (month) {
                    case 1:
                    case 2:
                    case 3:
                        season = "spring";
                        break;
                    case 4:
                    case 5:
                    case 6:
                        season = "summber";
                        break;
                    case 7:
                    case 8:
                    case 9:
                        season = "autumn";
                        break;
                    case 10:
                    case 11:
                    case 12:
                        season = "winter";
                        break;
                }
                System.out.println(season);
            } else {
                System.out.println("您的输入有误，请重新输入：");
            }
        }
    }
}