class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int ans = nums[0];

        for(int i = 1;i<nums.length;i++){
            nums[i] = nums[i] >= (nums[i] + nums[i - 1]) ? nums[i] : nums[i] + nums[i - 1];
            ans = ans >= nums[i] ? ans : nums[i];
        }

        return ans;
    }
}