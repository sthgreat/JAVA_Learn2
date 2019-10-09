package Algorithm;

public class Algorithm_19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     * 三种情况删除头节点，删除尾节点，删除中间节点
     * 采用二次遍历，第一次获得链表长度，第二次找到删除位置
     */
     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null){
                return head;
            }
            int count = 1;
            ListNode l = head;
            while(l.next!=null){
                l = l.next;
                count+=1;
            }
            l = head;
            int i = 1;
            while(i<count-n){
                l = l.next;
                i++;
            }
            if(count == n){ //删除头节点
                head = head.next;
            }else if(l.next.next == null){
                l.next = null;
            }else{
                ListNode temp = l.next;
                l.next = temp.next;
            }
            return head;
        }
    }
}
