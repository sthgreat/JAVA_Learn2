package Niuke;

/**
 * 使用深度优先中的一种进行深度优先遍历，记录层数
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;
 public TreeNode(int val) {
 this.val = val;
 }
 }
 */
public class ErChaShuDeShenDu {
    int count = 0;
    int result = 0;
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        count += 1;
        result = Math.max(count, result);
        if(node.left!=null){
            dfs(node.left);
            count -= 1;
        }
        if(node.right!=null){
            dfs(node.right);
            count -= 1;
        }
    }
}
