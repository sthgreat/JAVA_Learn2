package NiukeReal;


import java.util.Comparator;
import java.util.PriorityQueue;

public class jjj {
    public static void main(String[] args){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String num1 = String.valueOf(o1);
                String num2 = String.valueOf(o2);
                return num2.compareTo(num1);
            }
        });
        queue.add(12);
        queue.add(13);
        for(int i = queue.size() - 1;i>=0;i--){
            System.out.println(queue.poll());
        }
    }
}

class Solution {
    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for(int i = 2;i<=n;i++){
            int j = 2;
            arr[i] = arr[i - 1] + 1;
            while(i / (j * j) >= 0 && i - j*j >= 0){
                if(i / (j*j) == 0){
                    arr[i] = 1;
                }else{
                    arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
                }
                j++;
            }
        }
        for(int k : arr){
            System.out.print(k + " ");
        }
        System.out.println();
        return arr[n];
    }
}