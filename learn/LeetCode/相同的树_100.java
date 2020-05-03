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
 * 简单题，深度优先搜索
 */
public class 相同的树_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }else{
                return false;
            }
        }else if(p == null && q == null){
            return true;
        }
        return false;
    }
}
