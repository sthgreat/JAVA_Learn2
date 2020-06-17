package LeetCode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class 对称的二叉树_101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode rootLeft, TreeNode rootRight){
        if(rootLeft == null && rootRight == null){
            return true;
        }
        if(rootLeft == null || rootRight == null){
            return false;
        }
        return rootLeft.val == rootRight.val && isMirror(rootLeft.left, rootRight.right)
                && isMirror(rootLeft.right, rootRight.left);
    }
}
