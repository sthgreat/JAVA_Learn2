package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/***
 * 在排列中使用set记录当前轮次已经排在第一位的数，以此去重
 */
public class 全排列II_47 {
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        perm(nums,0,nums.length - 1);
        return result;
    }

    void perm(int[] nums, int start, int end){
        if(start == end){
            record(nums);
        }else{
            HashSet<Integer> set = new HashSet<>();
            for(int i = start;i<=end;i++){
                if(set.contains(nums[i])){
                    continue;
                }
                set.add(nums[i]);
                swap(nums, i, start);
                perm(nums, start+1,end);
                swap(nums, i, start);
            }
        }
    }

    void record(int[] nums){
        List<Integer> a = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            a.add(nums[i]);
        }
        result.add(a);
    }

    void swap(int[] n, int p1, int p2){
        int temp = n[p1];
        n[p1] = n[p2];
        n[p2] = temp;
    }
}
