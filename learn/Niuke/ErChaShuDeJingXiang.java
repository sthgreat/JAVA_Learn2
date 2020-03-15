package Niuke;

public class ErChaShuDeJingXiang {
    public class Solution {
        public void Mirror(TreeNode root) {
            if(root == null){
                return;
            }
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            Mirror(leftNode);
            Mirror(rightNode);
        }
    }
}
