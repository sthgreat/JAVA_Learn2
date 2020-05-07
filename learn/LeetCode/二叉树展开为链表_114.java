package LeetCode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/***
 * 先序遍历，每次将左子树变为右子树，原右子树接到原左子树最右边的叶子节点上
 */
public class 二叉树展开为链表_114 {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while(pre.right!=null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;

                root.left = null;
                root = root.right;
            }
        }
    }
}
