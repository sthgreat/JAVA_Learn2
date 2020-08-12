package Base;

import practice.QuickSort1;

import java.util.HashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class TTT{
    public static void main(String[] args){
        int[] a = new int[]{2,4,8,2,9,1};
        int[] b = TTT.QuickSort(a, 0, a.length - 1);
        for(int i : b){
            System.out.println(i);
        }
    }

    public static int[] QuickSort(int[] a, int start, int end){
        int left = start;
        int right = end;
        int t = a[start];
        while(left < right){
            while(a[right] > t && left < right){
                right --;
            }
            while(a[left] < t && left < right){
                left ++;
            }
            if(a[left] == a[right] && left < right){
                left++;
            }else {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        if(left - 1 > start) QuickSort(a, start, left);
        if(left + 1 < end) QuickSort(a, left + 1, end);
        return a;
    }
}