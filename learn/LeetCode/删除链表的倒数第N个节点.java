package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/***
 * 双指针法，一个指针提前向前移动N格，然后同时移动直到前面的指针指到末尾，此时后指针指向要删除的节点
 */
public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode delete = head;
        ListNode cur = head;
        while(n > 0){
            if(cur == null){
                return head;
            }
            cur = cur.next;
            n --;
        }
        while(cur != null){
            pre = delete;
            delete = delete.next;
            cur = cur.next;
        }

        if(pre == null){
            head = delete.next;
            delete.next = null;
            return head;
        }else{
            pre.next = delete.next;
            return head;
        }

    }
}
