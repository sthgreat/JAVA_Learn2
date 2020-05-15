package Test;


public class test {
    int count = 0;
    int result = 0;
    static void add(Integer i){
        i = 100;
    }

    public static void main(String[] args){
        Integer i = 9999;
        add(i);
        System.out.println(i);
    }
}