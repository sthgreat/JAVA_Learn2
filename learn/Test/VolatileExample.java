package Test;

import java.util.LinkedList;
import java.util.List;

public class VolatileExample {
    private int a = 0;
    private volatile boolean flag = false;

    public void writer(){
        a = 1;
        flag = true;
    }

    public void reader(){
        int i = 100;
        if(flag){
            i = a;
        }
        System.out.println(i);
    }

    public static void main(String[] args){
        VolatileExample v = new VolatileExample();
        for(int num = 0; num<=10;num++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    v.writer();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    v.reader();
                }
            }).start();
        }
    }
}