package Base;/*
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
public class Test {
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        Test t = new Test();
        String serialize = t.Serialize(node1);
        TreeNode deserialize = t.Deserialize(serialize);
        System.out.println(deserialize.val);
        System.out.println(deserialize.left.val);
        System.out.println(deserialize.right.val);
    }

    String Serialize(TreeNode root) {
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
        TreeNode node = new TreeNode(Integer.parseInt(pre[0]));

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

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}