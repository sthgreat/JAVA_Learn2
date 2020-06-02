package NiukeReal;

import java.util.*;

/***
 * 构建二叉树的同时进行计算，将数值保存在节点类中
 */
public class 将满二叉树转换为求和树 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String preS = sc.nextLine();
        String inS = sc.nextLine();
        String[] p = preS.split(" ");
        String[] ii = inS.split(" ");
        int[] pre = new int[p.length];
        int[] in = new int[ii.length];
        for(int i = 0;i<pre.length;i++){
            pre[i] = Integer.valueOf(p[i]);
        }
        for(int i = 0;i<in.length;i++){
            in[i] = Integer.valueOf(ii[i]);
        }
        TreeNode root = buildTree(pre, in, 0, pre.length - 1,0, in.length -1);
        inOrderPrint(root);
    }

    public static TreeNode buildTree(int[] pre, int[] in, int s1, int end1, int s2, int end2){
        if(s2 > end2){
            return null;
        }
        TreeNode node = new TreeNode(pre[s1]);
        for(int i = s2;i<=end2;i++){
            if(pre[s1] == in[i]){
                int offer = i - s2;
                node.left = buildTree(pre, in, s1 + 1,s1 + offer, s2, s2 + offer - 1);
                node.right = buildTree(pre,in, s1 + offer + 1,end1, s2 + offer + 1, end2);
                break;
            }
        }
        if(node.left != null){
            node.subVal += node.left.subVal + node.left.val;
        }
        if(node.right != null){
            node.subVal += node.right.subVal + node.right.val;
        }
        return node;
    }

    public static void inOrderPrint(TreeNode node){
        if(node.left!=null){
            inOrderPrint(node.left);
        }
        System.out.print(node.subVal + " ");
        if(node.right!=null){
            inOrderPrint(node.right);
        }
    }
}

class TreeNode{
    int val;
    int subVal;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
