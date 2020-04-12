package Niuke;

import java.util.*;

/***
 * 需要注意：最大值需要更新
 */
public class 滑动窗口的最大值 {
    int max;
    int curMax;

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(num.length < size || size == 0){
            return result ;
        }
        max = num[0];
        curMax = 0;
        for(int i = 0;i<size;i++){
            if(num[i]>max){
                max = num[i];
                curMax = i;
            }
        }
        for(int i = size - 1;i<num.length;i++){//判断最大值是否过期
            if(curMax < i - size + 1){//最大值过期
                findMax(num,i - size + 1, i);//更新最大值
                result.add(max);
            }else{
                if(max < num[i]){
                    max = num[i];
                    curMax = i;
                    result.add(max);
                }else{
                    result.add(max);
                }
            }
        }
        return result;
    }

    void findMax(int[] arr, int from, int to){
        max = arr[from];
        for(int i = from;i<=to;i++){
            if(arr[i] > max){
                max = arr[i];
                curMax = i;
            }
        }
    }
}