package Concurrent_Programe.consumerAndProductor.practice1;

public class Producer1 implements Runnable {
    private final ProductQueue queue;
    private int num;

    public Producer1(ProductQueue queue) {
        this.queue = queue;
        num = 0;
    }

    @Override
    public void run() {
        for(int i = 0;i<40;i++){
            try {
                produce(new Product1());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(Product1 p) throws InterruptedException {
        Thread.sleep(500);
        synchronized (queue){
            while(queue.getList().size() == queue.getMaxSize()){
                queue.wait();
            }
            queue.getList().add(p);
            num ++;
            System.out.println("生产了一件，共生产了: " + num + "件");
            queue.notifyAll();
        }
    }
}
