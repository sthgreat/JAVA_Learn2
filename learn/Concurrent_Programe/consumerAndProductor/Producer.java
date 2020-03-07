package Concurrent_Programe.consumerAndProductor;

public class Producer implements Runnable {
    private final Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            for (int i = 0;i<20;i++) {
                Thread.sleep(500);
                produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void produce() throws InterruptedException {
                synchronized (product){
                if(product.canProduce){
                    product.produce();
                    System.out.println(Thread.currentThread().getName()
                            +" 生产了一个"+product.getName()+"，当前剩余："+ product.getCount());
                    product.notifyAll();
                }else{
                    product.wait();
                }
            }

    }
}
