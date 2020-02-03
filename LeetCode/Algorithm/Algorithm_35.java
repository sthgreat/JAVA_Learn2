class Solution {
    private int result = 0;

    public int searchInsert(int[] nums, int target) {
        search(0,nums.length - 1,target,nums); //左侧下标，右侧下标
        return result;
    }

    void search(int left, int right, int target,int[] nums){
        if(target<nums[left]){
            result = left;
            return;
        }else if(target>nums[right]){
            result = right+1;
            return;
        }else if(target == nums[(left+right)/2]){
            result = (left+right)/2;
            return;
        }else if(target > nums[(left+right)/2]){
            search((left+right)/2+1,right,target,nums);
        }else if(target < nums[(left+right)/2]){
            search(left,(left+right)/2 - 1,target,nums);
        }
    }
}