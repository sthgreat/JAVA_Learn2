package IEEE;// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Identify {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int totalPeople = sc.nextInt();
        int lines = sc.nextInt();
        for(int i = 0;i<lines;i++){
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            if(map.containsKey(p1)){
                map.get(p1).add(p2);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(p2);
                map.put(p1, set);
            }
        }

    }
}