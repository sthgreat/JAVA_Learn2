package Niuke;

import java.util.*;

public class test2 {
    public static void main(String[] args){
        int[] a = new int[5];
        for(int i : a){
            System.out.println(i);
        }
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int start = 1;
        int end = 2;
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> record = new ArrayList<>();
        while(start < end){
            if(sum(record) == sum){
                ArrayList<Integer> newRecord = new ArrayList<>(record);
                result.add(newRecord);
                start++;
                record.remove(0);
            }else if(sum(record) < sum){
                end ++;
                record.add(end);
            }else{
                start ++;
                record.remove(0);
            }
        }
        return result;
    }

    public int sum(ArrayList<Integer> arr){
        if(arr.size() == 0){
            return 0;
        }
        int s = 0;
        for(int i : arr){
            s += i;
        }
        return s;
    }
}