package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class 二叉树的层序遍历_102 {
    private LinkedList<Integer> record;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> arr = new LinkedList<>();
        if(root!=null){
            arr.add(root);
        }
        while(!arr.isEmpty()){
            record = new LinkedList<>();
            for(int i = arr.size() - 1;i>=0;i--){
                TreeNode node = (TreeNode) arr.removeFirst();
                record.add(node.val);
                if(node.left!=null){
                    arr.add(node.left);
                }
                if(node.right!=null){
                    arr.add(node.right);
                }
            }
            ans.add(record);
        }
        return ans;
    }
}
