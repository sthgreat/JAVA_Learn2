package LeetCode;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 快慢指针定位中点，利用快指针判断链表奇偶
 * 利用栈存储前半段数值，然后利用慢指针遍历后半部分，进行判断
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode pre = head;
        ListNode last = head;
        while(last.next != null && last.next.next != null){
            last = last.next.next;
            pre = pre.next;
        }
        LinkedList<ListNode> nodeStack = new LinkedList<>();
        while(head != pre){
            nodeStack.add(head);
            head = head.next;
        }
        if(last.next != null && last.next.next == null){//偶数
            nodeStack.add(pre);
        }
        pre = pre.next;
        while(pre != null){
            ListNode n = nodeStack.removeLast();
            if(n.val != pre.val){
                return false;
            }
            pre = pre.next;
        }
        if(nodeStack.size() != 0){
            return false;
        }
        return true;
    }
}
