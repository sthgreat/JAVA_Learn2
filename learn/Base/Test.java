package Base;

import java.util.*;
public class Test {
    int max;
    int curMax;

    public static void main(String[] args){
        Test t = new Test();
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> integers = t.maxInWindows(num, 3);
        System.out.println();
        for(int i : integers){
            System.out.print(i+" ");
        }
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num.length < size){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        max = num[0];
        curMax = 0;
        for(int i = 0;i<size;i++){
            if(num[i]>max){
                max = num[i];
                curMax = i;
            }
        }
        for(int i = size - 1;i<num.length;i++){//判断最大值是否过期
            System.out.print(curMax+" "+(i-size+1)+".");
            if(curMax < (i - size + 1)){//最大值过期
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