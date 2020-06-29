package LeetCode;

import LeetCode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 二叉树最近的公共祖先II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p){
            return p;
        }else if(root == q){
            return q;
        }else if(root == null){
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){ //找到了，返回自己
            return root;
        }else if(left == null && right == null){
            return null;
        }else{
            if(left != null){
                return left;
            }else if(right != null){
                return right;
            }
        }
        return null;
    }
}