package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II_90 {
    private static List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        res.add(new ArrayList<Integer>());
        ArrayList<Integer> saveList = new ArrayList<>();
        Arrays.sort(nums);
        perm(saveList, nums, 0, nums.length - 1);
        return res;
    }


    void perm(ArrayList<Integer> saveList, int[] nums, int start, int end){
        if(start == end){
            saveList.add(nums[start]);
            System.out.println(saveList);
            recordToRes(saveList);
            saveList.remove(saveList.size() - 1);
            return;
        }
        for(int i = start;i<=end;i++){
            if(i - 1>=start && nums[i] == nums[i-1]){
                continue;
            }
            saveList.add(nums[i]);
            System.out.println(saveList);
            recordToRes(saveList);
            perm(saveList, nums, i+1,end);
            saveList.remove(saveList.size() - 1);
        }
    }

    void recordToRes(ArrayList<Integer> saveList){
        if(!res.contains(saveList)){
            ArrayList<Integer> arr = new ArrayList<>(saveList);
            res.add(arr);
        }
    }
}