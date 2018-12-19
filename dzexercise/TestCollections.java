package com.dzexercise;

import java.util.*;

/**
 * Autor : dong
 * Time:2018/12/18
 */
public class TestCollections {

    public static void code1() {

        //线程不安全
//        Map<String,String> map = new HashMap<>();
//        map.put("1","Java");

        //线程安全
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        System.out.println(map.getClass().getName());

    }

    public static void code2() {
        List<String> data = new ArrayList<>();
        for (int i = 65; i < 123; i++) {
            data.add(String.valueOf((char) i));
        }
        System.out.println("原始数据：" + data);

        //反转方法
        Collections.reverse(data);
        System.out.println("反转之后：" + data);

        //查找
        System.out.println(data.get(0));
        System.out.println(data.size());
        // 0- (size-1)
        //(-(insertion point) - 1) = >  -(58)-1
        int index = Collections.binarySearch(data, "z");
        System.out.println("查看z的下标：" + index);
        System.out.println("查看A的下标：" + Collections.binarySearch(data, "A"));

        //乱序
        Collections.shuffle(data);
        System.out.println(data);

        //1.非同步集合-> 同步集合
        //2.集合 -> 不可修改
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("1", "Java"));
        map = Collections.unmodifiableMap(map);//UnmodifiableMap
        // map.put("2", "C++");
    }

    public static void main(String[] args) {
//        List<String> data = new ArrayList<>();
//        for (int i = 65; i < 123; i++) {
//            data.add(String.valueOf((char) i));
//        }
//        Collections.reverse(data);
//        System.out.println(Collections.binarySearch(data,"A"));
//        System.out.println(Collections.binarySearch(data,"A"));
        List<String> data = new ArrayList<>();
        data.add("A");
        data.add("B");
        System.out.println(Collections.binarySearch(data, "A"));
        System.out.println(Collections.binarySearch(data, "B"));
    }
}
