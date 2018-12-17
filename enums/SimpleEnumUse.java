package com.enums;

/**
 * Autor : dong
 * Time:2018/12/17
 */

enum Spiciness {
    NOT, MILD, MEDIUM, HOT, FLAMING
}
//ordinal()方法    values()方法
public class SimpleEnumUse {
    public static void main(String[] args) {
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot);
        System.out.println();
        for (Spiciness t : Spiciness.values()) {
            System.out.println(t + ", ordinal " + t.ordinal());
        }
    }
}