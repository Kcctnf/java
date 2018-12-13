package com.dong;

/**
 * Autor : dong
 * Time:2018/12/12
 */
public class HoldBox {
    //1.int的默认值 为0，而Integer的默认值为null,在使用Integer前需要初始化。
    //2.int是基本类型，而Integer是包装类，可以自动 拆箱、拆箱，Integer封装了很多的方法，
    public static void main(String[] args) {
        byte b = 1;
        //Byte it = new Byte(i);
        //自动装箱
        Byte itb = b;
        //byte ii = it.byteValue();
        //自动拆箱
        byte bb = itb;
        System.out.println(bb);
    }

}
