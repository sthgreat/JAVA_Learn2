package mianshi;

import java.util.*;

public class Main {
    private static int ans;
    private static int total;


    public static void main(String[] args){
        ans = Integer.MAX_VALUE;
        total = 140;
        int[] arr = new int[]{30,60,5,15,30};
        func(arr, 0, 0, 0);
        System.out.println(ans);
    }

    public static void func(int[] arr, int curPos, int left, int right){
        if(curPos >= arr.length){
            return;
        }
        if(left == right){
            ans = Math.min(ans, total - left - right);
        }
        //当前加到左手
        func(arr, curPos + 1, left + arr[curPos], right);

        //当前加到右手
        func(arr, curPos + 1, left, right + arr[curPos]);

        //当前不加左手或者右手
        func(arr, curPos + 1, left, right);
    }

}