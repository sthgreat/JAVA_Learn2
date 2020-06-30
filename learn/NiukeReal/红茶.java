package NiukeReal;

import java.util.*;

public class 红茶 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int totalNum = sc.nextInt();
            int[] arr = new int[totalNum];
            for(int i = 0;i<arr.length;i++){
                arr[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            Arrays.sort(arr);
            find(arr, target);
        }
    }

    public static void find(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        boolean flag = false;
        while(left < right){
            if(arr[left] + arr[right] < target){
                left ++;
            }else if(arr[left] + arr[right] > target){
                right --;
            }else{
                flag = true;
                System.out.println(arr[left] + " " + arr[right]);
                left ++;
            }
        }
        if(!flag){
            System.out.println("NO");
        }
    }
}
