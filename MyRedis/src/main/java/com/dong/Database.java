package com.dong;

import java.util.*;

/**
 * Author : dong
 * Time:2019/8/2
 */
public class Database {

    //饿汉式单例
    private static Database instance  = new Database();
    public static Database getInstance(){
        return instance;
    }
    //string类型
    private Map<String,String> strings;
    //hash类型
    private Map<String,Map<String,String>> hashes;

    //List类型
    private Map<String,List<String>> lists;

    private Map<String,Set<String>> sets;

    private Map<String,LinkedHashSet<String>> zsets;

    private Database(){
        strings = new HashMap<>();
        hashes = new HashMap<>();
        lists = new HashMap<>();
        sets = new HashMap<>();
        zsets = new HashMap<>();
    }

    public List<String> getList(String key) {


        /*
        List<String> list = lists.computeIfAbsent(key,k->{
          return new arrayList<>();
        });
         */
        List<String> list = lists.get(key);

        if(list == null) {
            list = new ArrayList<>();
            lists.put(key,list);
        }
        return list;
    }
}
