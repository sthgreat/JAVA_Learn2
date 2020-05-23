package Test;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class test {
    int count = 0;
    int result = 0;
    static void add(Integer i){
        i = 100;
    }

    public static void main(String[] args){

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(null, 1);
        System.out.println(map.get(null));
    }
}