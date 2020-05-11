package Utils;

import LeetCode.Node;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LeetCodeUtil {
    public static void main(String[] args){
        Node node = LeetCodeUtil.buildTreeByArray(new int[]{1, -233, 3, -233, -233, 4, 5});
        LeetCodeUtil.showTree(node);
    }

    public static void showTree(Node node){
        if(node == null){
            return;
        }
        if(node.left != null){
            showTree(node.left);
        }
        if(node.val != -233){
            System.out.print(node.val + " ");
        }else{
            System.out.print("# ");
        }
        if(node.right!=null){
            showTree(node.right);
        }
    }

    public static Node buildTreeByArray(int[] arr){//通过层次遍历的数组构建树，用-233替代空节点
        if(arr.length == 0){
            return null;
        }
        Node node = new Node(arr[0]);
        if(arr.length == 1){
            return node;
        }
        LinkedList<Node> pre = new LinkedList<>();
        pre.add(node);
        build(pre, arr, 1);
        return node;
    }

    public static void build(LinkedList<Node> pre, int[] arr, int now){
        while(!pre.isEmpty()){
            for(int i = pre.size() -1 ;i>=0;i--){
                Node node = pre.removeFirst();
                if(now < arr.length){
                    Node nodeLeft = new Node(arr[now ++]);
                    node.left = nodeLeft;
                    pre.add(nodeLeft);
                }
                if(now < arr.length){
                    Node nodeRight = new Node(arr[now ++]);
                    node.right = nodeRight;
                    pre.add(nodeRight);
                }
            }
        }
    }

    public static int culculateLayerNum(int[] arr){
        int totalLength = 0;
        int i = 0;
        while(totalLength < arr.length){//当totalLength大于arr的长度时，表示能容下当前的arr
            totalLength += new Double(Math.pow(2, i)).intValue();
            i++;
        }
        return i;
    }
}
