package Base;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;

public class TangTang {
    int maxLayer=3;
    ArrayList<ArrayList<NodeNode>> result = new ArrayList<>();
    ArrayList<ArrayList<NodeNode>> init = new ArrayList<>();
    ArrayList<ArrayList<NodeNode>> all = new ArrayList<>();

    public void qiongJu(LinkedList<NodeNode> nodeList, LinkedList<NodeNode> l){//单行穷举
        if(nodeList.size() == 0){
            System.out.println(l.toString());
//            ArrayList<NodeNode> n = new ArrayList<>(l);
//            all.add(n);
            return;
        }
        for(int i = 0; i<nodeList.size();i++){
            NodeNode nodeNode = nodeList.removeFirst();
            l.add(nodeNode);
            qiongJu(nodeList, l);
            l.removeLast();
            nodeList.addLast(nodeNode);
        }
    }

    public void QiongJu(){//多行穷举
        for(int i = 0;i<init.size();i++){
            LinkedList<NodeNode> l = new LinkedList<>(init.get(i));
            qiongJu(l, new LinkedList<NodeNode>());
            all.add(null);
        }

        ArrayList<ArrayList<ArrayList<NodeNode>>> n = new ArrayList<>();
        int count = 0;
        while(true){
            ArrayList<ArrayList<NodeNode>> k = new ArrayList<>();
            while(all.get(count) != null){
                k.add(all.get(count));
                count ++;
            }
            n.add(k);
            count ++;
            if(count == all.size()){
                break;
            }
        }
        culculate(n, 1, new ArrayList<>());
    }

    public void culculate(ArrayList<ArrayList<ArrayList<NodeNode>>> n, int layer,
                          ArrayList<ArrayList<NodeNode>> nodeList){

    }

    public static void main(String[] args){
        ArrayList<ArrayList<NodeNode>> init = new ArrayList<>();
        NodeNode C1 = new NodeNode("C1");
        NodeNode C2 = new NodeNode("C2");
        ArrayList<NodeNode> B1R = new ArrayList<>();
        B1R.add(C1);B1R.add(C2);
        NodeNode B1 = new NodeNode("B1", B1R);
        ArrayList<NodeNode> B2R = new ArrayList<>();
        B2R.add(C1);
        NodeNode B2 = new NodeNode("B2", B2R);
        ArrayList<NodeNode> B3R = new ArrayList<>();
        B3R.add(C2);
        NodeNode B3 = new NodeNode("B3", B3R);
        ArrayList<NodeNode> A1R = new ArrayList<>();
        A1R.add(B1);
        A1R.add(B2);
        NodeNode A1 = new NodeNode("C1", A1R);
        ArrayList<NodeNode> A2R = new ArrayList<>();
        A2R.add(B3);
        NodeNode A2 = new NodeNode("C2", A2R);

        ArrayList<NodeNode> one = new ArrayList<>();
        ArrayList<NodeNode> two = new ArrayList<>();
        ArrayList<NodeNode> three = new ArrayList<>();
        one.add(A1);
        one.add(A2);
        two.add(B1);
        two.add(B2);
        two.add(B3);
        three.add(C1);
        three.add(C2);

        TangTang t = new TangTang();
        t.init.add(one);
        t.init.add(two);
        t.init.add(three);

        t.QiongJu();
//        t.qiongJu(two, new LinkedList<>());
    }
}







class NodeNode{
    String name;
    ArrayList<NodeNode> relation;

    public NodeNode(String name, ArrayList<NodeNode> relation) {
        this.name = name;
        this.relation = relation;
    }

    public NodeNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NodeNode{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<NodeNode> getRelation() {
        return relation;
    }

    public void setRelation(ArrayList<NodeNode> relation) {
        this.relation = relation;
    }
}