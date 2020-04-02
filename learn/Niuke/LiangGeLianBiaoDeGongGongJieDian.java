package Niuke;

import java.util.HashSet;

/***
 * 两个链表的公共节点
 * 双指针法，利用一个set存储两个链表遍历的节点值
 * 当遍历的当前节点在set中，则返回当前节点
 * 遍历完所有节点没有结果时返回空
 */
public class LiangGeLianBiaoDeGongGongJieDian {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        if (pHead1.val == pHead2.val) {
            return pHead1;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(pHead1.val);
        set.add(pHead2.val);
        while (pHead1 != null && pHead2 != null) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
            if (pHead1 == null || pHead2 == null) {
                break;
            }
            if (set.contains(pHead1.val)) {
                return pHead1;
            } else if (set.contains(pHead2.val)) {
                return pHead2;
            }
            set.add(pHead1.val);
            set.add(pHead2.val);
        }
        if (pHead1 == null) {
            while (pHead2 != null) {
                if (set.contains(pHead2.val)) {
                    return pHead2;
                }
                pHead2 = pHead2.next;
            }
        } else {
            while (pHead1 != null) {
                if (set.contains(pHead1.val)) {
                    return pHead1;
                }
                pHead1 = pHead1.next;
            }
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
