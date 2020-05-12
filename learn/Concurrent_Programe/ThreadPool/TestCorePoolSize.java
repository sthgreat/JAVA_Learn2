package Concurrent_Programe.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCorePoolSize {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(30), new ThreadPoolExecutor.CallerRunsPolicy());

        System.out.println(executor.getActiveCount());
        for(int i = 0; i < 2;i++){
            executor.execute(new TaskC());
        }
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getMaximumPoolSize());
        Future<?> submit = executor.submit(new TaskC());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(new TaskC());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getActiveCount());
    }
}

class TaskC implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}