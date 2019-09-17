package Test;

public class ThreadTest {

    public static void main(String[] args){
        ticket t = new ticket();
        People people = new People(t);
        new Thread(people,"线程1").start();
        new Thread(people,"线程2").start();
        new Thread(people,"线程3").start();
    }
}
