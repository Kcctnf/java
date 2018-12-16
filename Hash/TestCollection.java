package com.Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Autor : dong
 * Time:2018/12/16
 */
public class TestCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C");
        System.out.println(list);
        //集合反转
        Collections.reverse(list);
        System.out.println(list);
    }

}
