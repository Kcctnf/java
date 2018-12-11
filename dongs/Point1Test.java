package com.dongs;

/**
 * Autor : dong
 * Time:2018/12/11
 */
class Point1<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }
}

class MyClass<T>{
    public void fun(T t){
        System.out.println(t);
    }
    public <E> E fun1(E e){
        return e;
    }
}
public class Point1Test {
    public static void main(String[] args) {
        Point1<String> p = new Point1<String>();
        p.setX("横坐标4");
        p.setY("纵坐标7");
        String x = p.getX();
        String y = p.getY();
        System.out.println(p.getX() + p.getY());
        System.out.println("x=" + x +" " + "y=" + y);


        MyClass <String> myclass = new MyClass<String>();
        myclass.fun("hello word");
        Integer i = myclass.fun1(100);
        System.out.println(i);
    }

}
