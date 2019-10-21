package data_structure;

public class MyBinaryTree {
    private int size;
    private tree_node head;

    public tree_node getHead() {
        return head;
    }

    public void setHead(tree_node head) {
        this.head = head;
    }

    public static void main(String[] args){
        tree_node n1 = new tree_node('A');
        tree_node n2 = new tree_node('B');
        tree_node n3 = new tree_node('C');
        tree_node n4 = new tree_node('D');
        tree_node n5 = new tree_node('E');
        tree_node n6 = new tree_node('F');
        tree_node n7 = new tree_node('G');
        tree_node n8 = new tree_node('H');
        tree_node n9 = new tree_node('K');
        n1.setLeft(n2);
        n2.setRight(n3);
        n3.setLeft(n4);
        n1.setRight(n5);
        n5.setRight(n6);
        n6.setLeft(n7);
        n7.setLeft(n8);
        n7.setRight(n9);
        MyBinaryTree tree = new MyBinaryTree();
        tree.setHead(n1);
        tree.backOrder();
        System.out.println();
        tree.preOrder();
        System.out.println();
        tree.infixOrder();
    }

    public MyBinaryTree(){  //创建空的二叉树
        this.size = 0;
    }

    public MyBinaryTree(Object o){ //创建只有头节点的二叉树，提供头节点的值即可
        this.size = 1;
        head = new tree_node(o);
    }

    public void preOrder(){
        if(head!=null){
            this.head.preOrder();
        }else{
            System.out.println("该树为空，无法遍历");
        }
    }
    public void backOrder(){
        if(head!=null){
            this.head.backOrder();
        }else{
            System.out.println("该树为空，无法遍历");
        }
    }

    public void infixOrder(){
        if(head!=null){
            this.head.infixOrder();
        }else{
            System.out.println("该树为空，无法遍历");
        }
    }

//    public boolean isContain(Object o){ // 查找是否含目标o
//
//    }
//
//    public void set(Object o){ //将目标o按顺序加入树
//
//    }
}

class tree_node{
    private Object value;
    private tree_node left;
    private tree_node right;

    tree_node(Object o){
        this.value = o;
    }

    Object getValue() {
        return this.value;
    }

    void setValue(Object value) {
        this.value = value;
    }

    tree_node getLeft() {
        return this.left;
    }

    void setLeft(tree_node left) {
        this.left = left;
    }

    tree_node getRight() {
        return this.right;
    }

    void setRight(tree_node right) {
        this.right = right;
    }

    void preOrder(){
        System.out.println(this.value.toString());
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this.value.toString());
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    void backOrder(){
        if(this.left!=null){
            this.left.backOrder();
        }
        if(this.right!=null){
            this.right.backOrder();
        }
        System.out.println(this.value.toString());
    }
}