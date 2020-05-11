package Concurrent_Programe;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocal_Test {
    static final ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "默认值";
        }
    };
    public static void main(String[] args){
        String hello = "hello";
        threadLocal.set("ni");
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("你好！");
                System.out.println(threadLocal.get());
            }
        }).start();
        System.out.println("主进程：" + threadLocal.get());
    }
}
