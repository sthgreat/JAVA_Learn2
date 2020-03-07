package Concurrent_Programe.ThreadLocal;

public class ThreadLocalTest {
    public ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args){
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.threadLocal.set("主线程");
        Thread thread = new Thread(new TestThread(threadLocalTest));
        thread.start();
        System.out.println(threadLocalTest.threadLocal.get());
    }
}
