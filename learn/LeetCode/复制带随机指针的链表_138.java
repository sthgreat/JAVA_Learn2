package LeetCode;


import java.util.HashMap;

/***
 * 利用hashmap存放新旧指针的对应关系
 */
public class 复制带随机指针的链表_138 {
    public Node138 copyRandomList(Node138 head) {
        Node138 newHead = null;
        HashMap<Node138, Node138> map = new HashMap<>();
        while(head!=null){
            Node138 node = map.get(head);
            if(node == null){
                node = new Node138(head.val);
            }

            if(map.size() == 0){
                newHead = node;
            }
            map.put(head, node); //存放旧、新节点的对应关系

            if(head.random!=null){
                Node138 randomNode = map.get(head.random);
                if(randomNode!=null){
                    node.random = randomNode;
                }else{
                    node.random = new Node138(head.random.val);
                    map.put(head.random, node.random);
                }
            }

            if(head.next!=null){
                Node138 nextNode = map.get(head.next);
                if(nextNode!=null){
                    node.next = nextNode;
                }else{
                    node.next = new Node138(head.next.val);
                    map.put(head.next, node.next);
                }
            }

            head = head.next;
        }

        return newHead;
    }
}


// Definition for a Node.
class Node138 {
    int val;
    Node138 next;
    Node138 random;

    public Node138(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
