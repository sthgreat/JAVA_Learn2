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
 * 从上往下深度遍历，遍历到根节点时比较值，相同返回true，否则返回false
 */
public class 路径总和_112 {
    private static int s;

    public boolean hasPathSum(TreeNode root, int sum) {
        s = 0;
        return findPath(root, sum, s);
    }

    boolean findPath(TreeNode node, int sum, int curSum){
        if(node == null){//到达叶子节点的null节点还没有结果
            return false;
        }
        curSum += node.val;
        if(node.left == null && node.right == null){ //当前为叶子节点
            if(curSum == sum){
                return true;
            }
        }
        return findPath(node.left,sum,curSum) || findPath(node.right,sum,curSum);
    }
}
