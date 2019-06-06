package dong.work7;

import java.util.Scanner;

/**
 * Author : dong
 * Time:2019/6/5
 */

/**
 *
 * 每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，
 * 顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
 * 格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
 *
 *
 * 除0以外1-9中按照从小到大的顺序，将最小的数字输出1次
 * 输出所有出现的0
 * 输出1-9中按照从小到大的顺序，将每个数子输出出现的次数（第一位输出的数字会在第一次输出的时候减去
 * 1）
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
        for(int i = 0;i < 10;i++){
            num[i] = in.nextInt();
        }
        //输出一到九之间最小的数

        for(int i = 1;i < 10;i++){
            if(num[i] != 0){
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        while(num[0] != 0){
            System.out.print(0);
            num[0]--;
        }

        for(int i = 1;i < 10;i++){
            while(num[i] != 0){
                System.out.print(i);
                num[i]--;
            }
        }
    }

}






