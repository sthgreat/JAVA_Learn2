package LeetCode;

/***
 * 二分查找，可以根据原数组有序性判断前部分有序还是后部分有序，
 * 从而过滤掉一半的数组元素
 */
public class 搜索排序旋转数组II_81 {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + right >>> 1;
            if(nums[mid] == target){
                return true;
            }
            if(nums[left] > nums[mid]){ //后有序
                if(nums[mid] < target && nums[right] >= target){ //在后半部分
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else if(nums[left] < nums[mid]){ //前有序
                if(nums[left]<=target && nums[mid] > target){ //在前半部分
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                left ++;
            }
        }
        return false;
    }
}
