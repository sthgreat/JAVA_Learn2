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
 * 深度优先遍历，终止条件为到达叶子节点
 */
public class 求根到叶子节点数字之和_129 {
    private int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        if(root!=null){
            culculate(root, 0);
        }
        return ans;
    }

    void culculate(TreeNode node, int v){
        if(node.left == null && node.right==null){
            ans = ans + v * 10 + node.val;
            return;
        }

        if(node.left!=null){
            culculate(node.left, v * 10 + node.val);
        }

        if(node.right!=null){
            culculate(node.right, v*10 + node.val);
        }
    }
}
