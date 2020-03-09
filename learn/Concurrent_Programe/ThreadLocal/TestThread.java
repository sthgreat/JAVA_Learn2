package Concurrent_Programe.ThreadLocal;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class TestThread implements Runnable {
    private ThreadLocalTest test;

    public TestThread(ThreadLocalTest test) {
        this.test = test;
    }

    @Override
    public void run() {
//        test.threadLocal.set("线程1本地变量");
        System.out.println(test.threadLocal.get());
    }
}
