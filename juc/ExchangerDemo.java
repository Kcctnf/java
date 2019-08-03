package newreview.juc;

/**
 * Author : dong
 * Time:2019/8/2
 */

import java.util.concurrent.Exchanger;

/**
 * 线程交换器
 */
public class ExchangerDemo {
    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger();
        Thread girlThread = new Thread(() -> {
            try {
                String girl = exchanger.exchange("我喜欢你....");
                System.out.println("女生说" + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        girlThread.start();
        Thread boyThread = new Thread(() -> {
            try {
                String boy = exchanger.exchange("我喜欢你！");
                System.out.println("男生说" + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        boyThread.start();
    }
}
