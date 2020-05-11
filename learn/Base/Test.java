package Base;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    private final LinkedList<Integer> a = new LinkedList<>();

    private final LinkedList<Integer> b = new LinkedList<>();

    public static void main(String[] args){
        Test t = new Test();
        Thread a = new Thread(new TaskA(t));
        Thread b = new Thread(new TaskB(t));
        a.start();
        b.start();
    }

    public void lockA() {
        synchronized (this.a){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("锁了A！");
        }
    }

    public void lockB(){
        synchronized (this.b){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("锁了B！");
        }
    }

}

class TaskA implements Runnable{
    public Test test;

    public TaskA(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0;i<=5;i++){
            test.lockA();
        }
    }
}

class TaskB implements Runnable{
    public Test test;

    public TaskB(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0;i<=5;i++){
            test.lockB();
        }
    }
}