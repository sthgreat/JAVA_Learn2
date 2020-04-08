package Niuke;

import java.util.*;

/***
 * 使用双指针，维护一个arraylist（arr）记录当前存在的连续数字序列
 * 当arr取值等于目标时记录结果，最小指针往右，arr中去除左边的值
 * 当arr取值大于目标时，最小指针往右，arr中去除左边的值
 * 当arr取值小于目标时，最大指针往右，arr中添加右边的值
 */
public class 和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int start = 1;
        int end = 2;
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> record = new ArrayList<>();
        record.add(start);
        record.add(end);
        while(start < end){
            if(sum(record) == sum){
                ArrayList<Integer> newRecord = new ArrayList<>(record);
                result.add(newRecord);
                start++;
                record.remove(0);
            }else if(sum(record) < sum){
                end ++;
                record.add(end);
            }else{
                start ++;
                record.remove(0);
            }
        }
        return result;
    }

    public int sum(ArrayList<Integer> arr){
        if(arr.size() == 0){
            return 0;
        }
        int s = 0;
        for(int i : arr){
            s += i;
        }
        return s;
    }
}