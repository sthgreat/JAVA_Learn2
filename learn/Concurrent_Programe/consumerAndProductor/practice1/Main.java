package Concurrent_Programe.consumerAndProductor.practice1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        ProductQueue queue = new ProductQueue(10);
        Thread thread1 = new Thread(new Consumer1(queue));
        Thread thread2 = new Thread(new Producer1(queue));
        Thread thread3 = new Thread(new Consumer1(queue));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
