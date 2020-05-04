package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * 正常由左往右依次记录节点到队列中，同时按顺序取
 * 在将节点值添加到结果中判断该行是否该从右往左，
 * 若是，则将节点值加到当前轮次首位以实现从右往左
 */
public class 二叉树的锯齿形层序遍历_103 {
    private ArrayList<Integer> record;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> arr = new LinkedList<>();
        if(root != null){
            arr.add(root);
        }
        boolean isOdd = true; //单层从左往右为true，双层从右往左为false
        while(!arr.isEmpty()){
            record = new ArrayList<>();
            int size = arr.size() - 1;
            for(int i = size;i>=0;i--){
                TreeNode node = arr.removeFirst();
                if(isOdd){
                    record.add(node.val);
                }else{
                    record.add(0, node.val);
                }
                if(node.left!=null){
                    arr.add(node.left);
                }
                if(node.right!=null){
                    arr.add(node.right);
                }
            }
            ans.add(record);
            isOdd = !isOdd;
        }
        return ans;
    }
}
