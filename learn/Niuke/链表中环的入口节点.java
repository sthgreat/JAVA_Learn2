package Niuke;

import java.util.*;
public class 链表中环的入口节点 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashSet<Integer> set = new HashSet<>();
        while(pHead!=null){
            if(set.contains(pHead.val)){
                return pHead;
            }else{
                set.add(pHead.val);
                pHead = pHead.next;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}