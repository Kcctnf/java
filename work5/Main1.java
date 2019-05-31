package dong.work5;

/**
 * Author : dong
 * Time:2019/5/31
 */

import java.util.ArrayList;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e8bb8e68434e42acbcdff0341f2a32c5
 * 来源：牛客网
 * <p>
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，
 * 计算机器人有多少种走法。
 * <p>
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 * <p>
 * 测试样例：
 * 2,2
 * 返回：2
 */
public class Main1 {
    public static int counts(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        return counts(x - 1, y) + counts(x, y - 1);
    }

    public static void main(String[] args) {


        System.out.println(counts(2,2));
    }
}
