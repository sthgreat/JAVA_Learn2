package Test;


public class test {
    int count = 0;
    int result = 0;
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        count += 1;
        result = Math.max(count, result);
        if(node.left!=null){
            dfs(node.left);
            count -= 1;
        }
        if(node.right!=null){
            dfs(node.right);
            count -= 1;
        }
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n5.left = n7;
        test t = new test();
        System.out.println(t.TreeDepth(n1));
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}