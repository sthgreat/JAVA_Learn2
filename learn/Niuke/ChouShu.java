package Niuke;

/***
 * 丑数
 * 从小到大暴力穷举
 */

public class ChouShu {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7){
            return index;
        }
        int[] arr = new int[index];
        int n2=0,n3=0,n5=0;
        arr[0] = 1;
        for(int i = 1; i<index; i++){
            arr[i] = min(2 * arr[n2], 3*arr[n3], 5*arr[n5]);
            if(arr[i] == arr[n2] * 2) n2++;
            if(arr[i] == arr[n3] * 3) n3++;
            if(arr[i] == arr[n5] * 5) n5++;
        }
        return arr[arr.length - 1];
    }

    int min(int a, int b, int c){
        int temp = Math.min(a, b);
        return temp = Math.min(temp, c);
    }
}
