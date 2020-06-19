package NiukeReal;

import java.util.*;

public class 序列找数 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int[] arr = new int[max];
        for(int i = 0;i<max;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){
            if(i != arr[i]){
                System.out.println(i);
                break;
            }
        }
    }
}
