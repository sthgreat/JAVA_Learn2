package LeetCode;

import java.util.LinkedList;
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

/**
 * 层序遍历翻版
 */
public class 二叉树的右视图_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> layer = new LinkedList<>();
        if(root != null){
            layer.add(root);
        }
        add(ans, layer);
        return ans;
    }

    public void add(List<Integer> ans, LinkedList<TreeNode> layer){
        if(layer.size() == 0){//当前层为空
            return;
        }
        int lastValue = 0;
        for(int i = layer.size() - 1;i>=0;i--){
            TreeNode curNode = layer.removeFirst();
            if(i == 0){//当前层最后一个
                ans.add(curNode.val);
            }
            if(curNode.left != null){
                layer.add(curNode.left);
            }
            if(curNode.right != null){
                layer.add(curNode.right);
            }
        }
        add(ans, layer);
    }
}
