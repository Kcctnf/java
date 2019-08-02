package newreview.thread;

import java.util.concurrent.*;

/**
 * Author : dong
 * Time:2019/8/1
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1,3,
                60,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        CallableTask callableTask = new CallableTask();
        Future<String> submit = null;
        for(int i = 0; i < 3; i++) {
            //Future<String> submit = executorService.submit(callableTask);
            submit = executorService.submit(callableTask);

            //System.out.println(submit.get());
        }
        System.out.println(submit.get());
    }
}
