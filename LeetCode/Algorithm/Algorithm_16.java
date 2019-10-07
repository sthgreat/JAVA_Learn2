package Algorithm;

import java.util.Arrays;

public class Algorithm_16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int res = nums[0] + nums[1] + nums[2];
            Arrays.sort(nums);
            for(int i= 0; i < nums.length;i++){
                int start = i + 1;
                int end = nums.length - 1;
                while(start<end){
                    int sum = nums[i] + nums[start] + nums[end];
                    if(Math.abs(sum - target)<Math.abs(res - target)){
                        res = sum;
                    }
                    if(sum > target){
                        end--;
                    }
                    else if(sum<target){
                        start++;
                    }else{
                        return target;
                    }
                }
            }
            return res;
        }
    }
}
