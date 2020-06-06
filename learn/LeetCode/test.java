package LeetCode;

import LeetCode.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
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
        String ss = t.reverseWords("the sky is blue");
        System.out.println(ss);
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