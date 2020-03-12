package Concurrent_Programe.ThreadPool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {
    private static final int corePoolSize = 5;
    private static final int maxPoolSize = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final long keepAliveTime = 1L;


    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,maxPoolSize,keepAliveTime, TimeUnit.SECONDS
                ,new ArrayBlockingQueue<>(QUEUE_CAPACITY),new ThreadPoolExecutor.CallerRunsPolicy()
        );
        ArrayList<Future<String>> ThreadNames = new ArrayList<>();
        Callable<String> work = new Work();
        for(int i = 0; i<10;i++){
            Future<String> threadName = executor.submit(work);
            ThreadNames.add(threadName);
        }

        for(Future future : ThreadNames){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}

class Work implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
