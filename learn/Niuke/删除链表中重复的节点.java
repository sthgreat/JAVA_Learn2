package Niuke;

import java.util.*;

/***
 * 使用了三个指针来分别记录重复的片段和片段之前的节点
 */
public class 删除链表中重复的节点 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = null;
        ListNode now = pHead;
        ListNode p = null;
        while(now!=null){
            if(pre == null){//头节点
                pre = now;
                now = now.next;
                continue;
            }
            if(now.val == pre.val){
                while(now!=null && now.val == pre.val){
                    now = now.next;
                }
                if(p!=null){
                    p.next = now;
                    pre = p;
                }else{
                    pHead = now;
                    pre = null;
                    p = null;
                }
            }else{
                p = pre;
                pre = now;
                now = now.next;
            }
        }

        return pHead;
    }
}
