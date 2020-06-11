package LeetCode;

import java.util.LinkedList;

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
 * 先使用中序遍历记录顺序，之后输出就可
 */
public class 二叉搜索树迭代遍历器_173 {
    private LinkedList<Integer> list;

    public 二叉搜索树迭代遍历器_173(TreeNode root) {
        list = new LinkedList<>();
        if(root != null){
            add(list, root);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return list.removeFirst();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(list.size() > 0){
            return true;
        }else{
            return false;
        }
    }

    public void add(LinkedList<Integer> list, TreeNode node){
        if(node.left!=null){
            add(list, node.left);
        }
        list.addLast(node.val);
        if(node.right!=null){
            add(list,node.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
