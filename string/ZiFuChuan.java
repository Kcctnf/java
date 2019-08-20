package newreview.string.string;

/**
 * Author : dong
 * Time:2019/8/18
 */
public class ZiFuChuan {
    /**
     * 字符串的反转
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while(left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 输入：
     * ["a","a","b","b","c","c","c"]
     *
     * 输出：
     * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
     *
     * 说明：
     * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-compression
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int compress(char[] chars) {
        int len  = chars.length;
        int count = 0;
        int i = 0;
        int j = 0;
        int curr = -1;
        if(len <= 1) return len;
        while(j <= len) {
            if(j != len && chars[i] == chars[j]) {
                count++;
                j++;
            }
            if(j == len || chars[i] != chars[j]) {
                chars[++curr] = chars[i];
                if(curr + 1 <= len -1 && count != 0) {
                    for(char t : ((count + 1) + "").toCharArray()) {
                        chars[++curr] = t;
                    }
                    i = j;
                    j++;
                    count = 0;
                }
            }
        }
        return curr + 1;
    }
    /**
     * 字符串的相加
     */
    /*
    public ZiFuChuan addStrings(ZiFuChuan num1, ZiFuChuan num2) {
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while(i >= 0 || j >= 0 || curr != 0) {
            if(i >= 0) curr += num1.charAt(i--) - '0';
            if(j >= 0) curr += num2.charAt(j--) - '0';
            sb.append(curr % 10);
            curr /= 10;
        }
        return sb.reverse().toString();
    }
    */
}
