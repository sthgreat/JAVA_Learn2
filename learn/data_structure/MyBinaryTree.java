package data_structure;

public class MyBinaryTree {
    private int size;
    private tree_node head;

    public static void main(String[] args){
        MyBinaryTree tree = new MyBinaryTree();
    }

    public MyBinaryTree(){
        this.size = 0;
    }

    public MyBinaryTree(Object o){
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
}

class tree_node{
    private Object value;
    private tree_node left;
    private tree_node right;

    tree_node(Object o){
        value = o;
    }

    Object getValue() {
        return value;
    }

    void setValue(Object value) {
        this.value = value;
    }

    tree_node getLeft() {
        return left;
    }

    void setLeft(tree_node left) {
        this.left = left;
    }

    tree_node getRight() {
        return right;
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