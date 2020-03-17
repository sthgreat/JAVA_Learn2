package Niuke;

import java.util.ArrayList;

/***
 * 二叉树中和为某一值的路经：
 * 回溯遍历整棵树，使用一个固定变量保存内容，注意要在使用结束后删除当前添加的变量
 * 方法中定义的变量本身在方法结束时会被清除，但是其指向的对象不会立刻被消除
 */

public class ErChaShuZhongHeWeiMouYiZhiDeLuJing {
    public class Solution {
        private ArrayList<ArrayList<Integer>> result = new ArrayList<>();;

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            if(root == null){
                return result;
            }
            findPath(0, root, target, new ArrayList<Integer>());
            return result;
        }

        private void findPath(int sum, TreeNode root, int target, ArrayList<Integer> path){
            if(root.left == null && root.right == null){//叶子节点
                sum += root.val;
                if(sum == target){
                    path.add(root.val);
                    ArrayList<Integer> p = new ArrayList<>();
                    p.addAll(path);
                    result.add(p);
                    path.remove(path.size() - 1);
                    return;
                }else{
                    return;
                }
            }
            if(sum+root.val >= target){//此路不通
                return;
            }

            if(root.left!=null){
                path.add(root.val);
                findPath(sum+root.val, root.left, target, path);
                path.remove(path.size() - 1);
            }
            if(root.right!=null){
                path.add(root.val);
                findPath(sum+root.val, root.right, target, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
