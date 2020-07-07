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
public class 完全二叉树的节点个数_222 {
    public int countNodes(TreeNode root) {
        int count = func(root);
        return count;
    }

    private int func(TreeNode node){
        if(node == null){
            return 0;
        }else if(node.left == null && node.right == null){
            return 1;
        }
        int left = 0;
        int right = 0;
        if(node.left != null){
            left = func(node.left);
        }
        if(node.right != null){
            right = func(node.right);
        }
        return left + right + 1;
    }
}
