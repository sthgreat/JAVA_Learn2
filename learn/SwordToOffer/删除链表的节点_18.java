package SwordToOffer;

import LeetCode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 删除链表的节点_18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        if(head.val == val){ //头节点为删除节点
            p = p.next;
            head.next = null;
            return p;
        }
        while(p.next != null && p.next.val != val){
            p = p.next;
        }
        if(p.next == null){
            return head;
        }else{
            ListNode del = p.next;
            p.next = del.next;
            del.next = null;
        }
        return head;
    }
}
