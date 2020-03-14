package data_structure;

import java.util.Stack;

public class Test {
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
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.setHead(n1);
        backOrder(n1);
        System.out.println("");
        myBinaryTree.backOrder();
    }

    static void preOrder(tree_node node){
        if(node == null){
            return;
        }else{
            System.out.println(node.getValue());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    static void infixOrder(tree_node node){
        if(node.getLeft() != null){
            infixOrder(node.getLeft());
        }
        System.out.println(node.getValue());
        if(node.getRight() != null){
            infixOrder(node.getRight());
        }
    }

    static void backOrder(tree_node node){
        if(node.getLeft()!=null){
            backOrder(node.getLeft());
        }
        if(node.getRight()!=null){
            backOrder(node.getRight());
        }
        System.out.println(node.getValue());
    }
}
