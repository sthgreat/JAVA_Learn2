package LeetCode;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/***
 * 使用hashset
 */
public class 相交链表_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA != null && headB != null){
            if(set.contains(headA)){
                return headA;
            }else{
                set.add(headA);
                headA = headA.next;
            }
            if(set.contains(headB)){
                return headB;
            }else{
                set.add(headB);
                headB = headB.next;
            }
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }else{
                headB = headB.next;
            }
        }
        while(headA!=null){
            if(set.contains(headA)){
                return headA;
            }else{
                headA = headA.next;
            }
        }
        return null;
    }
}
