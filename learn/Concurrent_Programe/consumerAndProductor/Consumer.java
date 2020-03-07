package Concurrent_Programe.consumerAndProductor;

public class Consumer implements Runnable {
    private final Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            for(int i = 0;i<20; i++) {
                Thread.sleep(500);
                consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume() throws InterruptedException {
            synchronized (product){
                if(product.canConsume){
                    product.consume();
                    System.out.println(Thread.currentThread().getName()
                            +" 消费了一个"+product.getName()+"，当前剩余："+ product.getCount());
                    product.notifyAll();
                }else{
                    product.wait();
                }

        }

    }
}
