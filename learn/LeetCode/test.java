package LeetCode;

import LeetCode.ListNode;

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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(4);
        System.out.println(queue.peek());
    }
}