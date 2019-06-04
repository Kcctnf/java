package dong.work6;

import java.util.Scanner;

/**
 * Author : dong
 * Time:2019/6/4
 */

public class ZhengFX {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String b = in.nextLine();


        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){

                System.out.print(b);
                System.out.print(' ');
            }
            System.out.println();
        }
        */

            Scanner sc=new Scanner(System.in);
            int N=sc.nextInt();//输出的列数
            String c=sc.next();//输出的字符
            for(int i=1;i<=N;i++){//输出第一行
                System.out.print(c);
            }
            System.out.println();//第一行换行
            for(int i=1;i<=Math.ceil((double)N/2)-2;i++){//输出中间行
                System.out.print(c);//中间行第一个字符
                for(int j=2;j<=N-1;j++){
                    System.out.print(" ");//中间行其它字符为空字符串
                }
                System.out.println(c);//中间行最后一个字符
            }
            for(int i=1;i<=N;i++){//输出最后一行
                System.out.print(c);
            }
        }

    }


