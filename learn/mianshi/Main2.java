package mianshi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

public class Main2 {
    public static void main(String[] args){

    }
}

class MyBlockQueue<T>{
    public int maxSize;
    public int curSize;
    public LinkedList<T> list;

    public MyBlockQueue(int maxSize){
        this.maxSize = maxSize;
        curSize = 0;
        list = new LinkedList<>();
    }

    public synchronized void add(T t) throws InterruptedException {
        while (curSize == maxSize){
            this.wait();
        }
        curSize ++;
        list.addLast(t);
        this.notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (curSize == 0){
            this.wait();
        }
        curSize --;
        this.notifyAll();
        return list.removeFirst();
    }
}
