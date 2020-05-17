package LeetCode;

/***
 * 可以使用快慢指针来解决环形问题
 */

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class 环形链表_141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null){
            set.add(head);
            if(set.contains(head.next)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
