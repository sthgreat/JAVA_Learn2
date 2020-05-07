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
 * 自底向上的方法获得最小深度
 */
public class 二叉树的最小深度_111 {
    public int minDepth(TreeNode root) {
        return findDepth(root);
    }

    public int findDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){ //为叶子节点
            return 1;
        }
        int left = findDepth(node.left);
        int right = findDepth(node.right);
        if(left == 0){//左边无叶子节点
            return right + 1;
        }
        if(right == 0){//右边无叶子节点
            return left + 1;
        }
        return left < right ? left + 1 : right + 1;
    }
}
