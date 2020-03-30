package Niuke;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable{
    private int i = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
       HashMap h = new HashMap();
       h.remove(1);
    }


    @Override
    public void run() {
        while(i <= 10){
            lock.lock();
            c.signalAll();
            System.out.println(Thread.currentThread().getName() + "正在运行！" + i);
            i++;
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}

class ttt{
    int k;
}