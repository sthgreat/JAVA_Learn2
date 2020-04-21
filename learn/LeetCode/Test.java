package LeetCode;

public class Test {
    public static void main(String[] args){
        Test t = new Test();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode listNode = t.deleteDuplicates(n1);
        while(listNode!=null){
            System.out.println(listNode.toString());
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            while(cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }
            if(cur.next!=null){ //到达改变点
                cur = cur.next;
                pre.next = cur;
            }else{ //修改之前的pre节点指向null
                pre.next = null;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}