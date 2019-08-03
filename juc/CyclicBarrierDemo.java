package newreview.juc;

/**
 * Author : dong
 * Time:2019/8/2
 */

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 多线程向磁盘写数据
 */
class CBTask implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public CBTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "正在写入数据");
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "数据写入完毕");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,() -> {

            System.out.println("当前线程为" + Thread.currentThread().getName());
        });
        CBTask cbTask = new CBTask(cyclicBarrier);
        for(int i = 0 ; i < 4; i++){
            new Thread( cbTask,"写线程" + (i + 1)).start();
        }
    }
}
