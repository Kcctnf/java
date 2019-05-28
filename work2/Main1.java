package dong.work2;

import java.util.Scanner;

/**
 * Author : dong
 * Time:2019/5/25
 */

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35
 * 来源：牛客网
 *
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。
 * John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。
 * John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。
 * 现在的问题是，John有多少种不同的选择物品的方式。
 *
 * 输入描述:
 * 输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。
 * 接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
 *
 *
 * 输出描述:
 * 输出不同的选择物品的方式的数目。
 * 示例1
 * 输入
 * 3
 * 20
 * 20
 * 20
 * 输出
 * 3
 */
public class Main1 {

    static int[] array;
    static int a;
    static int count = 0;

    public static void count(int s, int n) {
        if (s == 0) {
            count++;
            return;
        }
        if (s < 0 || n < 1 && s > 0) {
            return;
        }
        count((s - array[a]), n - 1);
        count(s, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            array = new int[a + 1];
            for (int i = 0; i < a; i++) {
                array[i] = sc.nextInt();
            }

            count(40,a);
            System.out.println(count);
        }
    }
}

