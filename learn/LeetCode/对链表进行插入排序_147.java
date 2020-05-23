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
 *
 */
public class 对链表进行插入排序_147 {
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
                boolean flag = false;
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
                        flag = true;
                        break;
                    }else{
                        before = after;
                        after = after.next;
                    }
                }
                //走到这说明要加在末尾
                if(flag == false){
                    before.next = head;
                    head = head.next;
                    before.next.next = null;
                }
            }
        }
        return ans;
    }
}
