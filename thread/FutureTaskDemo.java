package newreview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author : dong
 * Time:2019/8/1
 */

class CallableTask implements Callable<String>{

    private int ticket = 20;
    @Override
    public String call() throws Exception {
        for(int i = 0;i < 20;i++){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"张票");
            }
        }
        return "票已经售完，下次见";
    }
}
public class FutureTaskDemo {
    public static void main(String[] args) {
        CallableTask callableTask = new CallableTask();
        FutureTask<String> futureTask = new FutureTask(callableTask);
        Thread thread = new Thread(futureTask,"黄牛A");
        Thread thread1 = new Thread(futureTask,"黄牛B");
        Thread thread2 = new Thread(futureTask,"黄牛C");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
