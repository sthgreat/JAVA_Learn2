package Base;

import java.util.*;

public class Test {
    private List<List<Integer>> result;

    public static void main(String[] args){
        Test t = new Test();
        List<List<Integer>> lists = t.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }

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
                if(set.contains(i)){
                    continue;
                }
                set.add(i);
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