package newreview.array;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author : dong
 * Time:2019/8/19
 */
public class Array {
    /**
     *求一个数组中的连续子向量的最大和
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = 0;
        if(nums == null || nums.length == 0) {
            return sum;
        }
        for(int i = 0; i < nums.length;i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static int maxArray(int[] array) {
        int sum = array[0];
        int maxSum = array[0];
        for(int i = 1; i < array.length;i++) {
            if(sum >= 0) {
                sum = sum + array[i];
            }else {
                sum = array[i];
            }
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    /**
     * 寻找一个数组中前k个最大的数
     * @param
     */

    public static List<Integer> findKLargst(int[] array,int k) {
        List<Integer> list = new ArrayList<>();
        if(array == null || array.length <= 0 || array.length < k) {
            return null;
        }

        Arrays.sort(array);
        for(int i = array.length - 1;i > array.length - 1 -k;i--) {
            list.add(array[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] array = {1,2,-3,4,-4,5,-6,4};
        //int[] array = {-1,1,2,0,3};
        //int[] array ={-1,-2,-3};
        //int a = maxSubArray(array);
        //System.out.println(a);
        System.out.println(maxArray(array));
        System.out.println(findKLargst(array,2));
    }
}
