package dong.work1;

/**
 * Author : dong
 * Time:2019/5/22
 */

/**
 * 给定一个数组，对于数组中的任意两个数字，只要前边的大于后边的，
 * 就说这两数字互为逆序数
 * [1,2,3,4,5,0]
 * 逆序数个数为5
 */
public class Main2 {
    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] A = {0, 2, 3,4, 5};
        int n = 5;
        System.out.println(count(A, n));
    }
}
