package IEEE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ttt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalNum = sc.nextInt();
        int totalLink = sc.nextInt();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //单向
        HashMap<Integer, HashSet<Integer>> map2 = new HashMap<>(); //双向
        for(int i = 0;i<totalLink;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            if(map.containsKey(n1)){
                map.get(n1).add(n2);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(n2);
                map.put(n1, set);
            }
            if(map2.containsKey(n1)){
                map2.get(n1).add(n2);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(n2);
                map2.put(n1, set);
            }
            if(map2.containsKey(n2)){
                map2.get(n2).add(n1);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(n1);
                map2.put(n2, set);
            }
        }

        for(Integer key : map.keySet()){
            for(Integer value : map.get(key)){
                if(!findOther(key, value, map2)){
                    System.out.println(key + " " + value);
                }
            }
        }
    }

    private static boolean findOther(int from, int to, HashMap<Integer, HashSet<Integer>> map){
        map.get(from).remove(to);
        map.get(to).remove(from);
        HashSet<Integer> visited = new HashSet<>();
        boolean flag = find(from, to, map, visited);
        map.get(from).add(to);
        map.get(to).add(from);
        return flag;
    }

    private static boolean find(int from, int to, HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> visited){
        if(from == to){
            return true;
        }
        if(visited.contains(from)){
            return false;
        }

        for(Integer num : map.get(from)){
            visited.add(from);
            if(find(num, to, map, visited)){
                visited.remove(from);
                return true;
            }
            visited.remove(from);
        }
        return false;
    }
}
