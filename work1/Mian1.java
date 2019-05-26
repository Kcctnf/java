package dong.work1;

import java.util.Scanner;

/**
 * Author : dong
 * Time:2019/5/22
 */
public class Mian1 {

    public static int drink(int n){
        int total = 0;

        while(n > 2){
            total = total + n / 3;
            n = n / 3 + n % 3;
        }

        if(n == 2){
            total = total + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()){
            n = sc.nextInt();
            System.out.println(drink(n));
        }
    }
}
