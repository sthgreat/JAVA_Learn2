class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int flag = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == val){
                count += 1;
            }else if(nums[i] != val && i!=flag){
                nums[flag] = nums[i];
                flag++;
            }else if(nums[i] != val && i==flag){
                flag++;
            }
        }
        return nums.length - count;
    }
}