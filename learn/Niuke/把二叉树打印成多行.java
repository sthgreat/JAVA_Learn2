package Niuke;

import java.util.*;


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/***
 * 利用队列先入先出的特性来解决问题
 */
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        if(pRoot == null){
            return result;
        }
        nodeList.add(pRoot);
        while(!nodeList.isEmpty()){
            int curSize = nodeList.size();
            ArrayList<Integer> curList = new ArrayList<>();
            for(int i = 0;i<curSize;i++){
                TreeNode curNode = nodeList.removeFirst();
                curList.add(curNode.val);
                if(curNode.left!=null){
                    nodeList.add(curNode.left);
                }
                if(curNode.right!=null){
                    nodeList.add(curNode.right);
                }
            }
            result.add(curList);
        }
        return result;
    }

}