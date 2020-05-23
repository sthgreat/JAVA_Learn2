package LeetCode;

import LeetCode.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class test {
    public static void main(String[] args){
        test t = new test();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        t.insertionSortList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode ans = null;
        while(head != null){
            if(ans == null){//首节点
                ans = head;
                head = head.next;
                ans.next = null;
            }else{//非首节点
                ListNode after = ans;
                ListNode before = null;
                while(after!=null){
                    if(after.val > head.val){
                        if(before == null){//应该放在首节点
                            ListNode temp = ans;
                            ListNode headNext = head.next;
                            ans = head;
                            ans.next = temp;
                            head = headNext;
                        }else{
                            before.next = head;
                            ListNode headNext = head.next;
                            head.next = after;
                            head = headNext;
                        }

                        break;
                    }else{
                        before = after;
                        after = after.next;
                    }
                }
                //走到这说明要加在末尾
                before.next = head;
                head = head.next;
                before.next.next = null;
            }
            System.out.println(ans.val);
        }

        return ans;
    }
}