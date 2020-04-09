package Base;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

/***
 * nodeArray
 * 层数从1开始算
 * 列数从0开始算
 */
public class Tang {
    NodeN[][] nodeArray;
    int totalCount; //总点数
    int lastLayCount; //最后一层的点数
    int totalLayer; //总层数
    NodeN[][] finalResult; //要输出的结果
    int[] nodeCountByLayer; //记录每一层有多少点
    int TypeCount; //一共穷举了多少种情况
    int minCount = 0; //最小交点数
    int flag = 0; //标记初始化情况

    public static void main(String[] args) throws IOException {
        Tang t = new Tang();
        t.readFromFile("E:\\example.txt");
        t.perm(1, 0, t.nodeCountByLayer[0] - 1);
        System.out.println(t.TypeCount);
        t.writeToFile("E:\\result2.txt");
    }

    public void writeToFile(String saveFile) throws IOException {
        File file = new File(saveFile);
        if(!file.exists()){
            boolean newFile = file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
        for(int i = 1; i<finalResult.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<nodeCountByLayer[i - 1];j++){
                if(j < nodeCountByLayer[i - 1] - 1){
                    sb.append(finalResult[i][j].id).append(",");
                }else{
                    sb.append(finalResult[i][j].id);
                }
            }
            writer.write(sb.toString() + "\r\n");
            writer.flush();
        }
        writer.close();
    }

    /**
     *
     * @param layer 当前的层数
     * @param start 头参数
     * @param end 尾参数
     */
    public void perm(int layer, int start, int end){ //全排序
        if(start == end){
            if(layer == totalLayer){//排到了底层
                judge();
            }else{
                perm(layer + 1,0,nodeCountByLayer[layer] - 1);
            }
        }else {
            for(int i= start;i <= end;i++){
                swap(layer, i, start);
                perm(layer,start + 1, end);
                swap(layer, i, start);
            }
        }
    }


    private void judge(){
        TypeCount++;
//        for(int i = 1; i <nodeArray.length;i++){
//            for(int j = 0;j<nodeCountByLayer[i - 1];j++){
//                System.out.print(nodeArray[i][j].toString() + ", ");
//            }
//        }
        int pointCount = 0;
        //算交点
        ArrayList<NodeLine> lineArray = new ArrayList<>();
        for(int i = 1; i <= totalLayer; i++){//当前层数
            lineArray.clear();
            for(int j = 0; j<nodeCountByLayer[i - 1];j++){//当前层点的排序
                for(int k = 0; k<nodeCountByLayer[i]; k++){//下一层点的排序
                    if(nodeArray[i][j].relation.contains(nodeArray[i+1][k].id)){
                        NodeLine newline = new NodeLine(j, k);
                        lineArray.add(newline);
                    }
                }
            }
            pointCount += culculate(lineArray);
        }
        if(flag == 0){
            minCount = pointCount;
            finalResult = CopyeOf(nodeArray);
            flag++;
        }
//        if(minCount == 0){//第一次
//            minCount = pointCount;
//            finalResult = CopyeOf(nodeArray);
//        }
        else{
            if(minCount > pointCount){
                finalResult = CopyeOf(nodeArray); //记录当前情况
                minCount = pointCount;
            }
        }
    }

    private int culculate(ArrayList<NodeLine> lineArray) {
        int count = 0;
        for(int i = 0; i<lineArray.size();i++){
            for(int j = i + 1; j<lineArray.size();j++){
                if(lineArray.get(i).start < lineArray.get(j).start
                && lineArray.get(i).end > lineArray.get(j).end){
                    count ++;
                }else if(lineArray.get(i).start > lineArray.get(j).start
                        && lineArray.get(i).end < lineArray.get(j).end){
                    count ++;
                }
            }
        }
        return count;
    }

    public void readFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename)),
                StandardCharsets.UTF_8));
        String lineTxt = null;
        int flag = 0;
        int max = 0; //记录需要建立多大的二维数组
        HashMap<Integer, Integer> map = new HashMap<>();//决定放在nodeArray某一层的第几个
        while ((lineTxt = br.readLine()) != null) {  //数据以逗号分隔
            String[] line = lineTxt.split(",");
            if(flag == 0){//第一行数据
                totalCount = Integer.parseInt(line[0]);
                lastLayCount = Integer.parseInt(line[line.length - 1]);
                nodeCountByLayer = new int[line.length];
                for(int i = 1; i<line.length;i++){
                    max = Math.max(max, Integer.parseInt(line[i]));
                    map.put(i, 0); //初始化
                    totalLayer ++;
                    nodeCountByLayer[i - 1] = Integer.parseInt(line[i]);
                }
                flag ++;
                nodeArray = new NodeN[max][max]; //建立空数组
            }else{
                ArrayList<Integer> arr = new ArrayList<>();
                for(int i = 2;i<line.length;i++){
                    arr.add(Integer.parseInt(line[i]));
                }
                NodeN newNode = new NodeN(Integer.parseInt(line[0]), Integer.parseInt(line[1]), arr);//组装node完成
                nodeArray[newNode.getLayId()][map.get(newNode.getLayId())] = newNode;
                map.put(newNode.getLayId(), map.get(newNode.getLayId()) + 1); //自增
            }
        }
        //补全最后一层
        int startNum = totalCount - lastLayCount;
        for(int i = 0;i<lastLayCount;i++){
            nodeArray[totalLayer][i] = new NodeN(startNum, totalLayer, null);
            startNum ++;
        }
    }

    private void swap(int layer, int p1, int p2){
//        NodeN swapNode = new NodeN(nodeArray[layer][p1].id, nodeArray[layer][p1].layId, nodeArray[layer][p1].relation);
//        nodeArray[layer][p1] = nodeArray[layer][p2];
//        nodeArray[layer][p2] = swapNode;
        NodeN swapNode = nodeArray[layer][p1];
        nodeArray[layer][p1] = nodeArray[layer][p2];
        nodeArray[layer][p2] = swapNode;
    }

    private NodeN[][] CopyeOf(NodeN[][] source){
        NodeN[][] newNodeArray = new NodeN[source.length][source[0].length];
        for(int i = 0;i<source.length;i++){
            System.arraycopy(source[i], 0, newNodeArray[i], 0, source.length);
        }
        return newNodeArray;
    }

    private void print(){
        for(int i = 1;i <= totalLayer;i++){
            for (int j = 0; j < nodeCountByLayer[i - 1] ;j++){
                System.out.print(nodeArray[i][j].toString() + ",,,");
            }
        }
        System.out.println(" ");
    }
}

class NodeN{
    int id;
    int layId;
    ArrayList<Integer> relation;

    public NodeN(int id, int layId, ArrayList<Integer> relation) {
        this.id = id;
        this.layId = layId;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "NodeN{" +
                "id=" + id +
                ", layId=" + layId +
                ", relation=" + relation +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLayId() {
        return layId;
    }

    public void setLayId(int layId) {
        this.layId = layId;
    }

    public ArrayList<Integer> getRelation() {
        return relation;
    }

    public void setRelation(ArrayList<Integer> relation) {
        this.relation = relation;
    }
}

class NodeLine{
    int start;
    int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public NodeLine(int start, int end) {
        this.start = start;
        this.end = end;
    }
}