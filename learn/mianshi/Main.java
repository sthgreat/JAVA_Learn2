package mianshi;

import java.util.*;

public class Main{
    public static void main(String[] args){
        boolean flag = true;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(2);
            flag = false;
        }else if(n == 2){
            System.out.println(3);
            flag = false;
        }else if(n == 3){
            System.out.println(5);
            flag = false;
        }
        if(!flag){
            char[] nums = new char[]{'2','3','5'};
            LinkedList<String> list = new LinkedList<>();
            list.add("2");
            list.add("3");
            list.add("5");
            int count = 0;
            while(count < n - 3){
                String s = list.removeFirst();
                for(int i = 0;i<3;i++){
                    StringBuilder sb = new StringBuilder(s);
                    sb.append(nums[i]);
                    count ++;
                    if(count >= n - 3){
                        System.out.println(sb.toString());
                        break;
                    }
                    list.add(sb.toString());
                }

            }
        }
    }
}