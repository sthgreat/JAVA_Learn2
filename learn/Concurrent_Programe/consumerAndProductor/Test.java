package Concurrent_Programe.consumerAndProductor;

public class Test {
    public static void main(String[] args){
        Product product = new Product("家用彩电",99.8,"高清电视",5);
        Thread producerThread_1 = new Thread(new Producer(product), "producer_1");
        Thread consumerThread_1 = new Thread(new Consumer(product), "consumer_1");
        Thread consumerThread_2 = new Thread(new Consumer(product), "consumer_2");
        producerThread_1.start();
        consumerThread_1.start();
        consumerThread_2.start();
    }
}
