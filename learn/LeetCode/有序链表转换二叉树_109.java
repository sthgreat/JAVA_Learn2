package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/***
 * 使用快慢指针遍历链表，以此获得中间值，可以比单指针快上不少
 */
public class 有序链表转换二叉树_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return buildTree(head);
    }

    TreeNode buildTree(ListNode node){
        if(node == null){
            return null;
        }
        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = null;
        while(fast.next != null && fast.next.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next!=null){//没有到头
            pre = slow;
            slow = slow.next;
        }
        //构造当前值为树节点，断开链表
        TreeNode n = new TreeNode(slow.val);
        if(pre!=null){
            pre.next = null;
            n.left = buildTree(node);
            n.right = buildTree(slow.next);
        }else{
            n.left = null;
            n.right = buildTree(slow.next);
        }

        return n;

    }
}
