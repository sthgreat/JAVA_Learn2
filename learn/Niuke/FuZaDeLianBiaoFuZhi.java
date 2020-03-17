package Niuke;

public class FuZaDeLianBiaoFuZhi {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode p = pHead;
        RandomListNode newHead = null;
        RandomListNode preNode = null;
        while(p!=null){
            RandomListNode newNode = new RandomListNode(p.label);
            if(preNode != null){//设置前面对象对于它的指针
                preNode.next = newNode;
            }else{
                newHead = newNode;
            }
            preNode = newNode;
            p = p.next;
        }
        p = pHead;
        RandomListNode p2 = newHead;
        while(p!=null){
            if(p.random!=null){//此时新链表节点的random节点有值
                RandomListNode p3 = newHead;
                while(p.random.label != p3.label){
                    p3 = p3.next;
                }
                //此时p3所指为新链表中应该是random的节点
                p2.random = p3;
            }
            p = p.next;
            p2 = p2.next;
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}