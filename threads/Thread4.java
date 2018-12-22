package com.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Autor : dong
 * Time:2018/12/22
 */
class MyCallable implements Callable<String> {
    private int tick = 10;

    @Override
    public String call() throws Exception {
        while (tick > 0) {
            //Thread.currentThread()获取当前线程，返回的是当前线程native 本地的
            System.out.println(Thread.currentThread().getName() + "剩余" + tick-- +
                    "张票");
            //tick++;
        }
        return "票卖完了";
    }
}

public class Thread4 {
    public static void main(String[] args) {
        Callable<String> callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
       // System.out.println(Thread.currentThread().getName());
    }
}