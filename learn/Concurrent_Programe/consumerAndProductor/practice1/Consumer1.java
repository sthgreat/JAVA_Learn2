package Concurrent_Programe.consumerAndProductor.practice1;

public class Consumer1 implements Runnable{
    private final ProductQueue queue;
    private int num = 0;

    public Consumer1(ProductQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (queue){
            while(queue.getList().size() == 0){
                queue.wait();
            }
            queue.getList().removeFirst();
            num ++;
            System.out.println("消费了一件，" + Thread.currentThread().getName() +"共消费了: " + num + "件");
            queue.notifyAll();
        }
    }
}
