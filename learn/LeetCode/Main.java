package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args){
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean flag = false;
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1; j<= (Math.min(i + k, nums.length)); j++){
                System.out.println(Math.abs(nums[i] - nums[k]));
                if(Math.abs(nums[i] - nums[k]) <= t){
                    return true;
                }
            }
        }
        return flag;
    }
}