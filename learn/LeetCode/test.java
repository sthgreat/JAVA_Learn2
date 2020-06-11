package LeetCode;

import LeetCode.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

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
        double a = 3;
        double b = 7;
        System.out.println(a/b);

    }
    public String reverseWords(String s) {
        int start = 0;
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                String temp = s.substring(start, i);
                if(temp.length() > 0){
                    list.add(temp);
                }
                start = i + 1;
            }
        }
        list.add(s.substring(start).trim());
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for(int i = size ;i>0;i--){
            sb.append(list.removeLast()).append(" ");
        }
        return sb.toString().trim();
    }
}