package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * 二分排序，先确定在左半边还是在右半边
 * 然后分开讨论，先将区域移动到target所在的区域，然后比较上面使用传统二分进行比较
 */
public class 搜索旋转排序数组_33 {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + right >>> 1;
            if(nums[nums.length - 1] < target){ //左半部分
                if(nums[mid] <= nums[nums.length - 1]){
                    right = mid;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }else{ //右半部分
                if(nums[mid] > nums[nums.length - 1]){
                    left = mid + 1;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        if(nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }
}
