package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/***
 * 构建邻接表，广度优先
 * 从入度为0的点开始遍历，将所有
 */
public class 课程表_207 {
    //不能有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();//邻接表
        LinkedList<Integer> queue = new LinkedList<>();
        for(int[] i : prerequisites){
            indegree[i[0]] ++;//入度+1
            if(map.get(i[1]) == null){//空的，新建表
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i[0]);
                map.put(i[1], l);
            }else{
                ArrayList<Integer> l = map.get(i[1]);
                if(!l.contains(i[0])){
                    l.add(i[0]);
                    map.put(i[1],l);
                }
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            Integer num = queue.removeFirst();
            numCourses --;
            ArrayList<Integer> li = map.get(num);
            if(li == null){//空的话即为单个点，没有邻接
                continue;
            }
            for(Integer i : li){
                indegree[i] --;//入度减1
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        return numCourses == 0;
    }
}
