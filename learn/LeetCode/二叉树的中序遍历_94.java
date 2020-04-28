package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 二叉树的中序遍历_94 {
    static ArrayList<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        inorder(root);
        return ans;

    }

    void inorder(TreeNode node){
        if(node.left!=null){
            inorder(node.left);
        }

        ans.add(node.val);

        if(node.right!=null){
            inorder(node.right);
        }
    }
}
