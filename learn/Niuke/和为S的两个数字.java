package Niuke;

import java.util.ArrayList;

/***
 * 1. 暴力求解
 * 2. 使用二分查找在数组中找到最接近sum/2的值，
 *      通过向左右扩散，找到最符合的值（辅以部分剪枝代码）
 *
 */
public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int target = sum / 2;
        int start = 0;
        int end = array.length - 1;
        if(array.length < 2){
            return new ArrayList<Integer>();
        }

        while(start < end){
            int mid = (start + end) >>> 1;
            if(array[mid] < target){
                start = mid + 1;
            }else if(array[mid] == target){
                start = mid;
                break;
            }else{
                end = mid;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int head = start;
        int tail = start + 1;
        for(int i = start; i>= 0; i--){
            if(array[i] + array[start + 1] > sum){
                continue;
            }
            for(int j = start + 1;j<array.length;j++){
                if(array[i] + array[j] > sum){
                    break;
                }
                if(array[i] + array[j] == sum){
                    if(i < head){
                        head = i;
                        tail = j;
                    }
                }
            }
        }
        if(array[head] + array[tail] != sum){
            return result;
        }
        result.add(array[head]);
        result.add(array[tail]);
        return result;
    }
}