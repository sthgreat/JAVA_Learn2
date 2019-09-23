package Algorithm;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int carry = 0;
        boolean flag = true;
        ListNode pin = result;
        while(flag){
            if(l1==null && l2 ==null){
                flag = false;
                if(carry == 1){
                    pin.val = 1;
                }
            }
            if(l1!=null&&l2!=null){
                int num = l1.val+l2.val+carry;
                if(num>=10){
                    pin.val = num%10;
                    carry = 1;
                    pin.next = new ListNode(0);
                    pin = pin.next;
                }else{
                    carry = 0;
                    pin.val = num;
                    if(l1.next != null || l2.next != null){
                        pin.next = new ListNode(0);
                        pin = pin.next;
                    }
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            if(l1 == null && l2!=null){
                int num = carry + l2.val;
                if(num>=10){
                    pin.val = num%10;
                    carry = 1;
                    pin.next = new ListNode(0);
                    pin = pin.next;
                }else{
                    carry = 0;
                    pin.val = num;
                    if(l2.next != null){
                        pin.next = new ListNode(0);
                        pin = pin.next;
                    }
                }
                l2 = l2.next;
            }
            if(l2 == null && l1!=null){
                int num = carry + l1.val;
                if(num>=10){
                    pin.val = num%10;
                    carry = 1;
                    pin.next = new ListNode(0);
                    pin = pin.next;
                }else{
                    carry = 0;
                    pin.val = num;
                    if(l1.next != null){
                        pin.next = new ListNode(0);
                        pin = pin.next;
                    }
                }
                l1 = l1.next;
            }
        }
        return result;
    }
}