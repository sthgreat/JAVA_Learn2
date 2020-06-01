package NiukeReal;

import java.nio.channels.ServerSocketChannel;
import java.util.*;
import java.util.concurrent.Future;

public class test {
    public static void main(String[] args){
        Queue<Tow> q = new PriorityQueue<>(new Comparator<Tow>() {
            @Override
            public int compare(Tow o1, Tow o2) {
                return o1.num - o2.num;
            }
        });
        q.add(new Tow(2));
        q.add(new Tow(4));
        q.add(new Tow(3));
        System.out.println(q.poll().toString());
    }
}

class Tow{
    int num;
    public Tow(int n){
        this.num = n;
    }
    public String toString(){
        return this.num + "";
    }
}
