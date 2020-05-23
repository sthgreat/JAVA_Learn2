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
 * 使用归并排序的方式来解决链表排序
 */
public class 排序链表_148 {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode mid = head;
        ListNode end = head;
        while(end.next != null && end.next.next != null){
            mid = mid.next;
            end = end.next.next;
        }
        ListNode head2 = mid.next;
        mid.next = null;

        if(head2 != null){
            ListNode first = sortList(head);
            ListNode second = sortList(head2);
            ListNode ans = merge(first, second);
            return ans;
        }else{//只有单个节点
            return head;
        }

    }

    public ListNode merge(ListNode head1, ListNode head2){//保证进来的不是空
        ListNode ans = null;
        ListNode p = null; // 指向答案的尾节点
        while(head1!=null && head2!=null){
            if(head1.val < head2.val){
                if(ans == null){
                    ans = head1;
                    head1 = head1.next;
                    ans.next = null;
                    p = ans;
                }else{
                    p.next = head1;
                    head1 = head1.next;
                    p = p.next;
                    p.next = null;
                }
            }else{
                if(ans == null){
                    ans = head2;
                    head2 = head2.next;
                    ans.next = null;
                    p = ans;
                }else{
                    p.next = head2;
                    p = p.next;
                    head2 = head2.next;
                    p.next = null;
                }
            }
        }
        if(head1!=null){
            p.next = head1;
        }
        if(head2!=null){
            p.next = head2;
        }
        return ans;
    }
}
