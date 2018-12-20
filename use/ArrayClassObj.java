package com.use;

import java.util.Arrays;
import java.util.Random;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Autor : dong
 * Time:2018/12/19
 */
public class ArrayClassObj {
    public static void code1() {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(20)];
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(20);
            System.out.print(Arrays.toString(a));
            System.out.print(a[i] + " ");
        }
    }

    public static void code2() {
        int[] a;
        Random rand = new Random(47);
        a = new int[rand.nextInt(20)];
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void code3() {
        Integer[] a = {new Integer(1), new Integer(2), 3};
        Integer[] b = new Integer[]{new Integer(1), new Integer(2), 3};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }

    public static void printArray(Object[] args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Object[]{new Integer[47],new Float[3],new Double[1111]});


        printArray(new Object[]{"one","two","three"});

        printArray(new Object[]{new A(),new A(),new A()});
    }
}
class A{

}