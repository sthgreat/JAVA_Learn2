package Niuke;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 使用队列保存用过的节点，利用先进先出的特性处理节点内容
 */
public class CongShangWangXiaDaYingErChaShu {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if(root == null){
            return result;
        }
        linkedList.add(root);
        while(linkedList.size()!=0){
            TreeNode node = linkedList.removeFirst();
            result.add(node.val);
            if(node.left!=null){
                linkedList.add(node.left);
            }
            if(node.right!=null){
                linkedList.add(node.right);
            }
        }
        return result;
    }
}