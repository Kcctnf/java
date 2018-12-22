package com.threads;

/**
 * Autor : dong
 * Time:2018/12/22
 */

public class Thread1 extends Thread {
    private final String title;

    public Thread1(String title) {
        this.title = title;
    }

    //run方法不会启用线程，只是普通的方法调用
    //多线程处理业务代码
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("xian cheng 1");
        thread1.run();
        thread1.start();//启用多线程

        Thread1 thread12 = new Thread1("xian cheng 2");
        thread12.run();
        thread12.start();
        thread12.start();//跑出一个异常，已经启动了，调一次即可

        //  private native void start0()本地的由C语言写的

    }
}
