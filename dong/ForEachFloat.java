package com.dong;

import java.util.Random;

/**
 * Autor : dong
 * Time:2018/12/13
 */
/*public class ForEachFloat {
    public static void main(String[] args) {
        Random random = new Random(47);
        float[] f = new float[10];
        for (int i = 0; i < 10; i++) {
            f[i] = random.nextFloat();
        }
        for (float x : f) {
            System.out.print(x);
            System.out.print(" ");
        }
    }
}*/

class ForEachInt {


}

public class ForEachFloat {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] data = new int[5];
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                data[i] = rand.nextInt();
            }
            for (int y : data) {
                System.out.print(y);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
