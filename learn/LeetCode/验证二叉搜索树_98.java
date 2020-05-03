package LeetCode;

import java.util.LinkedList;

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
 * 魔改中序遍历
 */
public class 验证二叉搜索树_98 {
    private LinkedList<Integer> numArr;
    public boolean isValidBST(TreeNode root) {
        numArr = new LinkedList<>();
        if(root == null){
            return true;
        }
        return inOrder(root);
    }

    boolean inOrder(TreeNode root){
        boolean left = true;
        boolean right = true;
        if(root.left != null){
            left = inOrder(root.left);
        }
        numArr.add(root.val);
        if(numArr.size() >= 2){
            if(numArr.get(numArr.size() - 1) <= numArr.get(numArr.size() - 2)){
                return false;
            }
        }
        if(root.right != null){
            right =  inOrder(root.right);
        }
        return left && right;
    }
}
