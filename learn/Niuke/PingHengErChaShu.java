package Niuke;

/***
 * 判断平衡二叉树
 * 递归判断它的左右子树是否都是二叉树
 *
 */
public class PingHengErChaShu {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftCount = count(root.left, 0);
        int rightCount = count(root.right, 0);
        if(Math.abs(leftCount-rightCount) > 1){
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    int count(TreeNode root, int c){
        if(root == null){
            return c;
        }
        c = c + 1;
        int c1 = count(root.left, c);
        int c2 = count(root.right, c);
        return Math.max(c1, c2);
    }
}