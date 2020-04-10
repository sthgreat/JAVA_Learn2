package Niuke;

/***
 * 一层层比较啦
 */
public class 对称的二叉树 {

    public boolean jude(TreeNode2 node1, TreeNode2 node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            return jude(node1.left, node2.right) && jude(node1.right, node2.left);
        }
    }

    public boolean isSymmetrical(TreeNode2 pRoot) {
        return pRoot==null || jude(pRoot.left, pRoot.right);
    }
}

class TreeNode2 {
    int val = 0;
    TreeNode2 left = null;
    TreeNode2 right = null;

    public TreeNode2(int val) {
        this.val = val;

    }

}