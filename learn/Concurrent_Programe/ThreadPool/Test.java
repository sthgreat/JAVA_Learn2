package Concurrent_Programe.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    int num = 0;
    volatile boolean flag = false;
    ReentrantLock lock = new ReentrantLock();
    Condition c = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100)
        );
        Test t = new Test();
        for(int i = 0;i<7;i++){
            threadPoolExecutor.submit(new AddTask(t));
        }
        while(!t.flag){

        }
        threadPoolExecutor.shutdown();
        System.out.println(t.num);
    }
}

class AddTask implements Runnable{
    Test t;
    AddTask(Test t){
        this.t = t;
    }

    @Override
    public void run() {
        while(t.num < 10000){
            t.lock.lock();
            try{
                if(t.num >= 10000){
                    t.flag = true;
                    break;
                }
                t.num ++;
                System.out.println("当前数字："+t.num);
            } finally {
                t.lock.unlock();
            }
        }
    }
}