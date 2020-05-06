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

/***
 * 与102题类似，不同的是在存入每一层结果时，存在队列头，以此达到翻转的目的
 */
public class 二叉树的层序遍历II_107 {
    private static List<List<Integer>> ans;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while(!nodeList.isEmpty()){
            LinkedList<Integer> record = new LinkedList<>();
            for(int i = nodeList.size() - 1;i>=0;i--){
                TreeNode node = nodeList.removeFirst();
                record.add(node.val);
                if(node.left!=null){
                    nodeList.add(node.left);
                }
                if(node.right!=null){
                    nodeList.add(node.right);
                }
            }
            ans.add(0, record);
        }
        return ans;
    }
}
