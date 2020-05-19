package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/***
 * 先使用快慢指针找到中点，再将后半部分切割出来反转
 * 最后按顺序遍历两个，依次处理节点，得到结果
 */
public class 重排链表_143 {
    public void reorderList(ListNode head) {
        ListNode Last = head;
        ListNode middle = head;
        if(head == null){
            return;
        }
        while(Last.next != null && Last.next.next != null){
            Last = Last.next.next;
            middle = middle.next;
        }
        // 奇、偶数队列 middle后面就是后半部分
        ListNode head2 = reverse(middle.next);
        middle.next = null;
        while(head != null && head2 != null){
            ListNode t1 = head.next;
            ListNode t2 = head2.next;
            head.next = head2;
            head2.next = t1;
            head = t1;
            head2 = t2;
        }
    }

    ListNode reverse(ListNode node){
        if(node == null){
            return null;
        }
        ListNode tail = node;
        ListNode head = node.next;
        while(head != null){
            ListNode temp = head.next;
            head.next = tail;
            if(tail == node){
                tail.next = null;
            }
            tail = head;
            head = temp;
        }
        return tail;
    }
}
