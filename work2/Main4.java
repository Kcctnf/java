package dong.work2;

/**
 * Author : dong
 * Time:2019/5/26
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/eac8c671a0c345b38aa0c07aba40097b
 * 来源：牛客网
 * <p>
 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
 * <p>
 * 输入描述:
 * 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 * <p>
 * 输出描述:
 * 输出出现次数大于等于n/2的数。
 * 示例1
 * 输入
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * 输出
 * 3
 */
/*public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int[] array = new int[str.length()];

            for(int i = 0;i < array.length;i++){
                array[i] = Integer.valueOf(strs[i]);
            }
            int count = 0;
            int num = array[0];

            for(int j = 0;j < array.length;j++){
                if(array[j] == num){
                    count++;
                }else if(count > 0){
                    count--;
                }else{
                    num = array[j];
                }
            }
            System.out.println(num);
        }
    }

}*/
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] number = new int[str.length];
        for(int i = 0; i < str.length; i++ ){
            number[i] = Integer.parseInt(str[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < number.length; i++){
            int count = 0;
            for(int j = 0; j < number.length; j++){
                if(number[i] == number[j]){
                    count++;
                }
            }
            map.put(number[i],count);
        }
        Set<Integer> keys = map.keySet();
        for(Integer key : keys){
            if(map.get(key) >= (number.length)/2){
                System.out.println(key);
            }
        }

    }
}
