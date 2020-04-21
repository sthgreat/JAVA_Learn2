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
 * 设置前置节点记录前半段未重复的链表
 * 随cur遍历链表，记录重复部分进行删除
 * 有很多细节需要注意...
 */
public class 删除排序链表中重复的元素_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                if(cur.next!=null){ //到达改变点
                    cur = cur.next;
                    if(pre!=null){
                        pre.next = cur;
                    }else{
                        head = cur;
                    }
                }else{ //修改之前的pre节点指向null
                    if(pre!=null){
                        pre.next = null;
                    }else{
                        return null;
                    }
                }
            }else{
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
