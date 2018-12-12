package com.dongs;

/**
 * Autor : dong
 * Time:2018/12/12
 */

interface IStudent<T>{
    public void print(T t);
}
//Number one   保留原来的泛型参数
class People1<T> implements IStudent<T>{
    @Override
    public void print(T t){
        System.out.println(t);
    }
}
//Number two  直接在实现接口的时候就给定数据类型
class People implements IStudent<String>{
    @Override
    public void print(String t){
        System.out.println(t);
    }
}
public class IterfacePoint {
    public static void main(String[] args) {
        IStudent<String> p = new People();
        p.print("hha");

        System.out.println();

        IStudent<Integer> m = new People1<Integer>();
        IStudent<Integer> m1 = new People1();
        m.print(100);
    }
}












