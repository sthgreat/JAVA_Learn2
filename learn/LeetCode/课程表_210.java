package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/***
 * 构建邻接表，广度优先
 * 从入度为0的点开始遍历
 * 中间记录过程
 */
public class 课程表_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for(int[] i : prerequisites){
            indegree[i[0]] ++;
            LinkedList<Integer> l = map.get(i[1]); //取邻接表
            if(l == null){
                l = new LinkedList<>();
                l.add(i[0]);
                map.put(i[1], l);
            }else{
                if(!l.contains(i[0])){
                    l.add(i[0]);
                    map.put(i[1], l);
                }
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i); //入度为0可看作起点
            }
        }
        List<Integer> ans = new LinkedList<>();
        while(!queue.isEmpty()){
            Integer num = queue.removeFirst();
            ans.add(num);
            numCourses --;

            //减邻接点的入度
            LinkedList<Integer> li = map.get(num);
            if(li == null){
                continue;
            }else{
                for(Integer n : li){
                    indegree[n] --;
                    if(indegree[n] == 0){ //及时加入入度为0的点
                        queue.add(n);
                    }
                }
            }
        }
        if(numCourses > 0){
            return new int[0];
        }
        int[] a = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            a[i] = ans.get(i);
        }
        return a;
    }
}
