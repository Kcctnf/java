package dong.work4;

/**
 * Author : dong
 * Time:2019/5/30
 */

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/6ffdd7e4197c403e88c6a8aa3e7a332a
 * 来源：牛客网
 *
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 *
 * 输入描述:
 * 输入为一行，n(1 ≤ n ≤ 1000)
 *
 * 输出描述:
 * 输出一个整数,即题目所求
 * 示例1
 * 输入
 * 10
 * 输出
 * 2
 */
public class Main4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0;

        for(int i = n;i >= 5;i++){
            int tem = i;
            while(tem % 5 == 0) {
                count++;
                tem /= 5;
            }
        }
        System.out.println(count);
    }
}
