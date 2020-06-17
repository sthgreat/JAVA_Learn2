package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 最大数_179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String num1 = String.valueOf(o1) + String.valueOf(o2);
                String num2 = String.valueOf(o2) + String.valueOf(o1);
                return num2.compareTo(num1);
            }
        });
        for(int i : nums){
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int siz = queue.size();
        boolean isFirst = true;
        for(int i = 0;i<siz;i++){
            int num = queue.poll();
            if(isFirst && i!=siz - 1 && num == 0){
                continue;
            }
            isFirst = false;
            sb.append(num);
        }
        return sb.toString();
    }
}
