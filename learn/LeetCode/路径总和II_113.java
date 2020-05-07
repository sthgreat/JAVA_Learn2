package LeetCode;

import java.util.LinkedList;
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

/***
 * 深度优先遍历，使用一个linkedlist记录经过的节点，
 * 到达叶子节点的时候比较值，相同则加入结果，
 * 每一次比较完成后需要将加入linkedlist的节点再次取出
 */
public class 路径总和II_113 {
    private static List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new LinkedList<>();
        findPath(root, sum, 0, new LinkedList<Integer>());
        return ans;
    }

    void findPath(TreeNode node, int sum, int curSum, LinkedList<Integer> list){
        if(node == null){
            return;
        }
        curSum += node.val;
        list.add(node.val);
        if(node.left == null && node.right == null){//到达叶子节点
            if(curSum == sum){
                LinkedList<Integer> record = new LinkedList<>(list);
                ans.add(record);
            }
        }else{
            findPath(node.left, sum, curSum, list);
            findPath(node.right, sum, curSum, list);
        }
        list.removeLast();
    }
}
