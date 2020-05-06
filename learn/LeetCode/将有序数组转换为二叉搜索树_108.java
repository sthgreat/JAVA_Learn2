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
 * 思路很简单，将数组进行二分，小的在左子树，大的在右子树，依次构建
 */
public class 将有序数组转换为二叉搜索树_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    TreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + end >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, start, mid-1);
        node.right = buildTree(nums, mid + 1, end);
        return node;
    }
}
