package LeetCode;

import java.util.*;

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
 * 使用迭代的方式获得前序遍历
 * 关键词：广度优先遍历使用队列
 * 深度优先遍历使用栈
 */
public class 二叉树的前序遍历_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        if(root != null){
            list.add(root);
        }
        while(!list.isEmpty()){
            TreeNode node = list.removeLast();
            ans.add(node.val);
            if(node.right!=null){
                list.add(node.right);
            }
            if(node.left!=null){
                list.add(node.left);
            }
        }

        return ans;
    }
}
