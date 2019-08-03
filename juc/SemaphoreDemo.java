package newreview.juc;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 */
class SemaphoreTask implements Runnable {
    private Semaphore semaphore;

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(2);
            System.out.println(Thread.currentThread()
                    .getName()+"占用2台设备生产");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread()
                    .getName()+"生产完毕，释放设备");
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        SemaphoreTask task = new SemaphoreTask(semaphore);
        for (int i = 0; i < 8; i++) {
            new Thread(task,"工人"+(i+1)).start();
        }
    }
}
