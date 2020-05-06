package LeetCode;

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
 * 自底向上的写法
 */
public class 平衡二叉树_110 {
    public boolean isBalanced(TreeNode root) {
        return judge(root) >= 0;
    }

    int judge(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = judge(node.left);
        if(left == -1){
            return -1;
        }
        int right = judge(node.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(left-right) < 2 ? Math.max(left,right) +1 : -1;
    }
}
