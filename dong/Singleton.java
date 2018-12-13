package com.dong;

/**
 * Autor : dong
 * Time:2018/12/12
 */

//e汉式单例
class Singleton1{
    public static final Singleton1 SING = new Singleton1();
    private Singleton1(){

    }
    public static Singleton1 getSingleton1(){
        return SING;
    }
    public void print(){
        System.out.println("hello world");
    }
}
//懒汉式单例
class Singleton2{
    public static Singleton2 sing1;
    private Singleton2(){

    }
    public static Singleton2 getSingleton2(){
        if(sing1==null){
            sing1 = new Singleton2();
        }
        return sing1;
    }

}
public class Singleton {
    public static void main(String[] args){
        Singleton1 singleton1 = null;
        singleton1 = Singleton1.getSingleton1();
        singleton1.print();

        System.out.println();
        Singleton2 singleton2 = Singleton2.getSingleton2();
        singleton1.print();

    }
}
