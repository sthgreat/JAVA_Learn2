package LeetCode;

import LeetCode.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class test {
    public static void main(String[] args){
        test t = new test();
        String s = t.convert("LEETCODEISHIRING", 3);
        System.out.println(s);
    }

    public String convert(String s, int numRows) {
        int r = 1;
        HashMap<Integer, String> map = new HashMap<>();
        boolean flag = true; //true时递增，false时递减
        for(int i = 0;i<s.length();i++){
            add(map, i, r,s);
            if(r == numRows){
                flag = false;
            }else if(r == 1){
                flag = true;
            }
            if(flag){
                r++;
            }else{
                r--;
            }
        }
        String ans = "";
        for(int i = 1;i<=numRows;i++){
            ans += map.get(i);
        }
        return ans;
    }

    public static void add(HashMap<Integer, String> map, int cur, int h, String s){
        System.out.println(h);
        if(!map.containsKey(h)){
            map.put(h, s.charAt(cur) + "");
        }else{
            map.put(h, map.get(h) + s.charAt(cur));
        }
    }
}