package LeetCode;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;

/***
 * 层序遍历的思想，只不过在每一层遍历节点的同时把同一层的后续节点作为next节点
 */
public class 填充每个节点的下一个右侧节点指针_116 {

    public Node connect(Node root) {
        LinkedList<Node> record = new LinkedList<>();
        if(root!=null){
            record.add(root);
        }
        while(!record.isEmpty()){
            for(int i = record.size()-1;i>=0;i--){
                Node node = record.removeFirst();
                if(i - 1 >= 0){//当前层还有后续节点
                    node.next = record.getFirst();
                }else{//当前层没有后续节点
                    node.next = null;
                }
                if(node.left != null){
                    record.add(node.left);
                }
                if(node.right != null){
                    record.add(node.right);
                }
            }
        }

        return root;
    }
}
