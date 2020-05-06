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
public class 从中序与后序遍历序列构造二叉树_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0){
            return null;
        }
        return buildRoot(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode buildRoot(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2){
        if(start2 > end2){
            return null;
        }
        int rootNum = postorder[end2];
        TreeNode node = new TreeNode(rootNum);
        for(int i = start1;i<=end1;i++){
            if(inorder[i]==rootNum){
                int offer = i - start1;
                node.left = buildRoot(inorder, start1, i - 1, postorder, start2, start2 + offer - 1);
                node.right = buildRoot(inorder, i+1, end1, postorder, start2 + offer, end2 - 1);
                break;
            }
        }
        return node;
    }
}
