package Algorithm;

public class Algorithm_21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     * 迭代法计算，两边遍历
     * 还可以使用递归
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(-1);
            ListNode pin = result;
            while(l1!=null && l2!=null){
                if(l1.val<=l2.val){
                    pin.next = l1;
                    pin = pin.next;
                    l1 = l1.next;
                }else{
                    pin.next = l2;
                    pin = pin.next;
                    l2 = l2.next;
                }
            }
            if(l1 == null){
                pin.next = l2;
                return result.next;
            }else if(l2 == null){
                pin.next = l1;
                return result.next;
            }else{
                return result.next;
            }
        }
    }
}
