package Niuke;/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;

/***
 * 注意“.”不能作为字符串分隔符？？
 * 可参考根据中序前序遍历恢复二叉树，将二叉树序列化为中序和前序遍历节点顺序
 * 也可采用层序遍历的方式，记录空节点和层序
 */
public class 序列化二叉树 {
    static StringBuilder pre;
    static StringBuilder in;

    String Serialize(TreeNode root) {
        pre = new StringBuilder();
        in = new StringBuilder();
        if(root == null){
            return "";
        }
        preOrder(root);
        inOrder(root);
        pre.append("#").append(in.toString());
        return pre.toString();
    }

    TreeNode Deserialize(String str) {
        if(str.equals("")){
            return null;
        }
        String preString = str.split("#")[0];
        String inString = str.split("#")[1];
        //TreeNode root = new TreeNode(Integer.parseInt(pre.charAt(0)));
        String[] p = preString.split("!");
        String[] i = inString.split("!");
        return reBuild(p,i);
    }

    TreeNode reBuild(String[] pre,String[] in){
        if(pre.length == 0){
            return null;
        }
        int mid = 0;
        for(int i = 0;i<in.length;i++){
            if(pre[0].equals(in[i])){
                mid = i;
            }
        }
        TreeNode node = new TreeNode(Integer.valueOf(pre[0]));

        node.left = reBuild(Arrays.copyOfRange(pre, 1, mid + 1),Arrays.copyOfRange(in, 0, mid));
        node.right = reBuild(Arrays.copyOfRange(pre, mid + 1, pre.length), Arrays.copyOfRange(in, mid + 1,in.length));

        return node;
    }

    public static void preOrder(TreeNode root){
        pre.append(root.val).append("!");
        if(root.left!=null){
            preOrder(root.left);
        }
        if(root.right!=null){
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root){
        if(root.left!=null){
            inOrder(root.left);
        }
        in.append(root.val).append("!");
        if(root.right!=null){
            inOrder(root.right);
        }
    }
}