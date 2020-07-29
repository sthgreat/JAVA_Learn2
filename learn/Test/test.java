package Test;


import javafx.scene.layout.Priority;

import java.util.*;

public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            func(s);
        }
    }

    public static void func(String s){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0;i<s.length();i++){
            Integer num = s.charAt(i) - '0';
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        //这里将map.entrySet()转换成list
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        //然后通过比较器来实现排序
        //升序排序
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            } else {
                return -o1.getValue() + o2.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> mapping:list){
            char c = (char) (mapping.getKey() + '0');
            System.out.println(c);
        }
    }
}
