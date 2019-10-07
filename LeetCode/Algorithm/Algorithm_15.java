package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0;i<nums.length - 1;i++){
                if(nums[i]>0){
                    break;
                }
                int before = i + 1;
                int back = nums.length - 1;
                if((i-1>0)&&(nums[i] == nums[i-1])){
                    continue;
                }
                while(before<back){
                    if(nums[i] + nums[before] + nums[back] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[before]);
                        temp.add(nums[back]);
                        if(!result.contains(temp)){
                            result.add(temp);
                        }
                        before+=1;
                    }
                    if(nums[i] + nums[before] + nums[back] < 0){
                        before+=1;
                    }
                    if(nums[i] + nums[before] + nums[back] > 0){
                        back-=1;
                    }
                }
            }
            return result;
        }
    }
}
