package LeetCode;

import java.util.*;
import java.util.HashMap;

/***
 * 深度优先原则，需要考量解决重复问题（这里利用了hashmap）
 */
public class 克隆图_133 {
    HashMap<Integer, GraphNode> record;
    public GraphNode cloneGraph(GraphNode node) {
        record = new HashMap<>();
        GraphNode newNode = null;
        if(node!=null){
            newNode = new GraphNode(node.val);
            // record.put(node.val, newNode); //记录当前节点已经存在
            create(node, newNode);
        }
        return newNode;
    }

    public void create(GraphNode origin, GraphNode newNode){
        if(record.get(newNode.val) != null){ //已经创建过，无需再次创建
            return;
        }

        record.put(newNode.val, newNode);

        for(GraphNode neighbor : origin.neighbors){
            if(record.get(neighbor.val) != null){ //邻居已经被创建
                newNode.neighbors.add(record.get(neighbor.val));
            }else{
                GraphNode newNeighbor = new GraphNode(neighbor.val);
                // record.put(newNeighbor.val, newNeighbor);
                newNode.neighbors.add(newNeighbor);
                create(neighbor, newNeighbor);
            }
        }
    }
}

// Definition for a Node.
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}