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
 * 快慢指针，除此之外还需要创建后半部分的头用来标记后面的排序链表
 */
public class 分隔链表_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode back = null;
        ListNode backHead = null;

        while(cur!=null){
            if(cur.val >= x){
                if(pre == null){ //当前头节点大于x
                    if(backHead == null){
                        backHead = cur;
                        back = cur;
                        cur = cur.next;
                        head = cur;
                        back.next = null;
                    }else{
                        back.next = cur;
                        cur = cur.next;
                        head = cur;
                        back = back.next;
                        back.next = null;
                    }
                }else{
                    if(backHead == null){
                        backHead = cur;
                        back = cur;
                        cur = cur.next;
                        pre.next = cur;
                        back.next = null;
                    }else{
                        back.next = cur;
                        cur = cur.next;
                        pre.next = cur;
                        back = back.next;
                        back.next = null;
                    }
                }
            }else{
                pre = cur;
                cur = cur.next;
            }
        }

        if(pre == null){
            return backHead;
        }
        pre.next = backHead;
        return head;
    }
}
