package Concurrent_Programe.consumerAndProductor.practice1;

import java.util.LinkedList;

public class ProductQueue {
    private LinkedList<Product1> list;
    private int maxSize;

    public ProductQueue(int maxSize){
        this.maxSize = maxSize;
        list = new LinkedList<>();
    }

    public ProductQueue() {
        this.maxSize = 10;
        list = new LinkedList<>();
    }

    public LinkedList<Product1> getList() {
        return list;
    }

    public void setList(LinkedList<Product1> list) {
        this.list = list;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
