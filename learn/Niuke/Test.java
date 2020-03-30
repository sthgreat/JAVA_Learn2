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
        LinkedList<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        System.out.println(a.pollLast());
        System.out.println(a.size());
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