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
 * 与从上向下打印二叉树思想相同，使用一个队列记录一层的所有点，
 * 根据flag值判断数值应该从右往左添加还是从左往右添加
 */
public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> pointList = new LinkedList<>();
        if(pRoot==null){
            return list;
        }
        boolean isOdd = true;
        pointList.add(pRoot);
        while(!pointList.isEmpty()){
            int curSize = pointList.size();
            ArrayList<Integer> curList = new ArrayList<>();//保存每一层的所有点
            for(int i = 0;i<curSize;i++){
                TreeNode curNode = pointList.removeFirst();
                if(isOdd){
                    curList.add(curNode.val);
                }else{
                    curList.add(0, curNode.val);
                }
                if(curNode.left!=null){
                    pointList.add(curNode.left);
                }
                if(curNode.right!=null){
                    pointList.add(curNode.right);
                }
            }
            list.add(curList);
            isOdd = !isOdd;//改变层序
        }
        return list;
    }
}