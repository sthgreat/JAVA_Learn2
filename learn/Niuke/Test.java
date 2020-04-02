package Niuke;

import other.HuaWei;

import java.io.IOException;
import java.util.*;

public class Test {
    static List<Integer> trace;
    static Set<Integer> searched=new HashSet<>();
    static Set<List<Integer>> allCircles = new HashSet<>();

    public static void main(String[] args) throws IOException {
//        int[][] e={{0,1,1,0,0,0,0}, {0,0,0,1,0,0,0},
//                {0,0,0,0,0,1,0}, {0,0,0,0,1,0,0},
//                {0,0,1,0,0,0,0}, {0,0,0,0,1,0,1},
//                {1,0,1,0,0,0,0}};
        int[][] e = HuaWei.readFromFile("E:\\test_data.txt");
        for(int i=0;i<e.length;i++){
            if(searched.contains(i))
                continue;
            trace =new ArrayList<>();
            findCycle(i,e);
        }

        for(List<Integer> list:allCircles)
            System.out.println("circle: "+list);
    }


    static void findCycle(int v, int[][]e){
        int j=trace.indexOf(v);
        if(j!=-1) {
            List<Integer> circle=new ArrayList<>();
            while(j<trace.size()) {
                circle.add(trace.get(j));
                j++;
            }
            Collections.sort(circle);
            allCircles.add(circle);
            return;
        }


        trace.add(v);
        for(int i=0;i<e.length;i++) {
            if(e[v][i]==1){
                searched.add(i);
                findCycle(i,e);
            }
        }
        trace.remove(trace.size()-1);
    }

}