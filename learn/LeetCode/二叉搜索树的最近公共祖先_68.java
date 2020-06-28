package LeetCode;

import java.util.HashSet;

public class 二叉搜索树的最近公共祖先_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        HashSet<TreeNode> set = new HashSet<>();
        while(node != p){
            set.add(node);
            if(node.val > p.val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        set.add(p);
        node = root;
        TreeNode ans = root;
        while(node != q){
            if(set.contains(node)){
                ans = node;
            }
            if(node.val > q.val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        if(set.contains(q)){
            ans = q;
        }
        return ans;
    }
}
