package dong.work6;

/**
 * Author : dong
 * Time:2019/6/4
 * <p>
 * 1. 标题：无缓存交换 | 时间限制：3秒 | 内存限制：32768K | 语言限制：[Python, C++, C#, Java]
 * 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
 * 给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 * 输入描述：
 * 输出描述：
 * 示例1:
 * 输入
 * 输出
 * <p>
 * public class Main2 {
 * <p>
 * public int[] AB(int[] AB) {
 * <p>
 * AB[0] = AB[0] ^ AB[1];
 * AB[1] = AB[1] ^ AB[0];
 * AB[0] = AB[0] ^ AB[1];
 * return AB;
 * }
 * <p>
 * public static void main(String[] args) {
 * <p>
 * }
 * }
 */

/**
 * 1. 标题：无缓存交换 | 时间限制：3秒 | 内存限制：32768K | 语言限制：[Python, C++, C#, Java]
 * 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
 * 给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 * 输入描述：
 * 输出描述：
 * 示例1:
 * 输入
 * 输出
 */

/**
 * public class Main2 {
 *
 *     public int[] AB(int[] AB) {
 *
 *         AB[0] = AB[0] ^ AB[1];
 *         AB[1] = AB[1] ^ AB[0];
 *         AB[0] = AB[0] ^ AB[1];
 *         return AB;
 *     }
 *
 *     public static void main(String[] args) {
 *
 *     }
 * }
 */

/**
 2. 标题：生成格雷码 | 时间限制：3秒 | 内存限制：32768K | 语言限制：[Python, C++, C#, Java]
 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请
 编写一个函数，使用递归的方法生成N位的格雷码。
 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 测试样例：
 1
 NOWCODER.COM
 牛客网·互联网名企笔试/面试题库
 牛客出品-http://www.nowcoder.com
 返回：["0","1"]
 输入描述：
 输出描述：
 示例1:
 输入
 输出
 */
public class Main2 {
    public class GrayCode {
        public String[] getGray(int n) {
            String[] resStrs = null;
            if (n == 1) {
                resStrs = new String[]{"0", "1"};
            } else {
                String[] strs = getGray(n - 1);
                resStrs = new String[2 * strs.length];
                for (int i = 0; i < strs.length; i++) {
                    resStrs[i] = "0" + strs[i];
                    resStrs[resStrs.length - 1 - i] = "1" + strs[i];
                }
            }
            return resStrs;
        }
    }

    public static void main(String[] args) {

    }
}