package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 反转链表II_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int cur = 1;
        ListNode p = head;
        ListNode list2 = null;
        ListNode list2_back = null;
        ListNode pre = null;
        while(cur<m){
            pre = p;
            p = p.next;
            cur++;
        }
        while(cur<=n){
            ListNode temp  = list2;
            list2 = new ListNode(p.val);
            if(temp == null){
                list2_back = list2;
            }
            list2.next = temp;
            p=p.next;
            cur++;
        }

        if(pre==null){
            head = list2;
            list2_back.next = p;
        }else{
            pre.next = list2;
            list2_back.next = p;
        }
        return head;
    }
}
