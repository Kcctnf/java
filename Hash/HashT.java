package com.Hash;

import java.util.*;

/**
 * Autor : dong
 * Time:2018/12/16
 */
public class HashT {

    public static void main(String[] args) {

        //线程不安全
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "hello");
// key重复
        //key ==  null     NPException
        //value == null    NPException
        //synchronized   存在于HashTable
        map.put(null, "haha");
        map.put(4, null);
        map.put(1, "Hello");
        map.put(3, "Java");
        map.put(2, "Bit");
        System.out.println(map);

        //线程安全
        Map<String, String> map1 = Collections.synchronizedMap(new HashMap<>());
        System.out.println(map1.getClass().getName());
    }

}






















