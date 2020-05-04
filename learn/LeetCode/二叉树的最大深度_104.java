package LeetCode;

/***
 * 使用深度优先遍历
 */
public class 二叉树的最大深度_104 {
    int ans = 0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        getDepth(root, 1);
        return ans;
    }

    void getDepth(TreeNode root, int depth){
        ans = Math.max(depth, ans);
        if(root.left!=null){
            getDepth(root.left, depth + 1);
        }
        if(root.right!=null){
            getDepth(root.right, depth + 1);
        }
    }
}
