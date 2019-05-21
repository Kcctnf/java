package homework;

/**
 * Author : dong
 * Time:2019/5/21
 */
import java.util.Scanner;
public class Main{

    public static boolean isBack(String s){

        int begin = 0;
        int end = s.length() - 1;
        while(begin < end){
            if(s.charAt(begin) != s.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {


        Scanner sn = new Scanner(System.in);
        String s1 = sn.nextLine();
        String s2 = sn.nextLine();
        int count = 0;
        for(int i = 0;i <= s1.length();i++){
            StringBuilder sb = new StringBuilder(s1);
            sb.insert(i,s2);
            if(isBack(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
