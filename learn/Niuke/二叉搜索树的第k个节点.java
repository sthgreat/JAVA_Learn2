package Niuke;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/***
 * 中序遍历即为从小到大的顺序排列
 * 要注意如何避免继续遍历其他元素
 * （添加一个计数器）
 */
public class 二叉搜索树的第k个节点 {

    TreeNode treeNode = null;
    int count = 0;

    void dfs(TreeNode pRoot, int k) {

        if (count < k && pRoot.left != null) {
            dfs(pRoot.left, k);
        }

        if (++count == k) {
            treeNode = pRoot;
        }

        if (count < k && pRoot.right != null) {
            dfs(pRoot.right, k);
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }

        dfs(pRoot, k);
        return treeNode;
    }
}