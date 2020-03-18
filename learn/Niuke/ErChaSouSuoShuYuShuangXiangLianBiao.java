package Niuke;

/***
 * 思路：中序遍历可以获得树的从小到大的排列
 * 提前预留一个指针指向树当前遍历的前一个节点，据此更改两个节点的指向
 */

public class ErChaSouSuoShuYuShuangXiangLianBiao {
    private TreeNode pin;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        pin = null;
        midOrder(pRootOfTree);
        while(pRootOfTree.left!=null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public void midOrder(TreeNode node){
        if(node.left!=null){
            midOrder(node.left);
        }
        node.left = pin;
        if(pin!=null){
            pin.right = node;
        }
        pin = node;
        if(node.right!=null){
            midOrder(node.right);
        }
    }
}
//
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}