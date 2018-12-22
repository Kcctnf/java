package com.threads;

/**
 * Autor : dong
 * Time:2018/12/22
 */

public class Thread3 extends Thread{
    private static int tick = 10;//static 可有可无  static 为类的属性  不是对象的
    @Override
    public void run(){
        while(tick > 0){
            System.out.println(this.getName() + "剩余" + tick-- + "张票");
        }
    }

    public static void main(String[] args){
        Runnable runnable = new Runnable(){
            private int tick = 10;
            @Override
            public void run(){
                while(tick > 0){
                    //Thread.currentThread()获取当前线程，返回的是当前线程native 本地的
                    System.out.println(Thread.currentThread().getName() + "剩余" + tick-- + "张票");
                }
            }
        };
        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();




       /* Thread3 thread3 = new Thread3();
        thread3.setName("Thread-A");
        Thread3 thread33 = new Thread3();
        thread33.setName("Thread-B");
        thread3.start();
        thread33.start();*/
    }
}