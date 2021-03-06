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
public class test2 {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> print = Print(null);
//        System.out.print(print.to);
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> pointList = new LinkedList<>();
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