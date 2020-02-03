/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pin = head;
        while(pin!=null && pin.next != null){
            if(pin.val == pin.next.val){
                pin.next = pin.next.next;
            }else{
                pin = pin.next;
            }
        }
        return head;
    }
}