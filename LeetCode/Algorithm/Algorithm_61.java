/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k == 0){
            return head;
        }
        ListNode pointer = head;
        ListNode tail = null;
        int count = 0;
        while(pointer != null){
            if(pointer.next == null){
                tail = pointer;
            }
            count ++;
            pointer = pointer.next;
        }
        pointer = head;
        if(k>count){
            k = k % count;
        }
        if(count == 1 || count == k){
            return head;
        }
        if(k == 0){
            return head;
        }

        int totalMoveCount = count - k > 0 ? count - k : count - Math.abs(count - k);

        for(int i = 0; i < totalMoveCount - 1;i++){
            pointer = pointer.next;
        }

        ListNode new_head = pointer.next;
        pointer.next = null;
        tail.next = head;
        return new_head;
    }
}