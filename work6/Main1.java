package dong.work6;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Author : dong
 * Time:2019/6/1
 */
public class Main1 {

    public  void add(int b){
        b = b++;
    }
    public void test(){
        int a =127;
        int b = 127;
        add(++a);
        System.out.println(a+" ");
        add(b);
        System.out.println(b+" ");
    }

    public static void main(String[] args) {

        Main1 m = new Main1();

        m.test();
    }
}
