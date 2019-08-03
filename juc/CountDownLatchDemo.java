package newreview.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author : dong
 * Time:2019/8/2
 */
//运动员线程
class CDLTask implements Runnable{
    private CountDownLatch countDownLatch;

    public CDLTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "开始跑步");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "跑步结束");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CDLTask cdlTask = new CDLTask(countDownLatch);
        System.out.println("比赛开始");
        new Thread(cdlTask,"一号运动员").start();
        new Thread(cdlTask,"二号运动员").start();
        new Thread(cdlTask,"三号运动员").start();
        new Thread(cdlTask,"四号运动员").start();
        //等待所有线程执行完毕,执行
        countDownLatch.await();
        System.out.println("比赛结束....");
    }
}
