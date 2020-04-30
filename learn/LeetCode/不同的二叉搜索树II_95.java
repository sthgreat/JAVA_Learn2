package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 不同的二叉搜索树II_95 {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if(n<=0){
            return ans;
        }
        return getAns(1,n);
    }

    ArrayList<TreeNode> getAns(int start,int end){
        ArrayList<TreeNode> ans = new ArrayList<>();
        if(start > end){
            ans.add(null);
            return ans;
        }

        if(start == end){
            TreeNode root = new TreeNode(start);
            ans.add(root);
            return ans;
        }

        for(int i = start;i<=end;i++){
            ArrayList<TreeNode> leftTrees = getAns(start,i-1);
            ArrayList<TreeNode> rightTrees = getAns(i+1,end);
            for(TreeNode treeleft : leftTrees){
                for(TreeNode treeright : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = treeleft;
                    root.right = treeright;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}
