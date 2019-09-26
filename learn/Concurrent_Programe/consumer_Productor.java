package Concurrent_Programe;

import java.util.LinkedList;

public class consumer_Productor{
    private final int MAX = 10;
    private LinkedList<Object> list = new LinkedList<>();

    public void produce() throws InterruptedException {
        synchronized (list){
            while(list.size()+1>MAX){
                System.out.println("仓库已满，生产者"+Thread.currentThread().getName()+"无法继续");
                list.wait();
            }

            list.add(new Object());
            System.out.println("生产者："+Thread.currentThread().getName()+"已经生产了一件物品，现有库存："+list.size());
            list.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (list){
            while(list.size()==0){ //此处要用while，用if会跳出，逃过检查
                System.out.println("仓库已无剩余库存，"+Thread.currentThread().getName()+"需要等待");
                list.wait();
            }
            list.remove();
            System.out.println("消费者:"+Thread.currentThread().getName()+"已经消费了一个产品，现库存为："+list.size());
            list.notifyAll();
        }
    }

    public static void main(String[] args){
        consumer_Productor cp = new consumer_Productor();
        Thread t1 = new Thread(new consumer(cp),"消费者1");
        Thread t2 = new Thread(new productor(cp),"生产者1");
        Thread t3 = new Thread(new productor(cp),"生产者2");
        Thread t4 = new Thread(new consumer(cp),"消费者2");
        Thread t5 = new Thread(new productor(cp),"生产者3");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}

class consumer implements Runnable{
    private consumer_Productor cp;

    public consumer(consumer_Productor cp) {
        this.cp = cp;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(500);
                cp.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class productor implements Runnable{
    private consumer_Productor cp;

    public productor(consumer_Productor cp) {
        this.cp = cp;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(500);
                cp.produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}