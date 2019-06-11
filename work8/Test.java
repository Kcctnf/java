package dong.work8;

import java.math.BigInteger;

/**
 * Author : dong
 * Time:2019/6/7
 */
public class Test {


//        String p1 = args[1];
//        String p2 = args[2];
//        String p3 = args[3];
//        System.out.println(p1+p2+p3);

//        int n = 10;
//        double n1 = 3.14;
//        System.out.println('A' + n + n1);


    public String str = "6";

    public static void main(String[] args) {
        Test sv = new Test();
        sv.change(sv.str);
        System.out.println(sv.str);
    }

    //值传递
    public void change(String str) {
        str = "10";
    }
}




