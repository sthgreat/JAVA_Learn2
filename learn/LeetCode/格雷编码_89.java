package LeetCode;

import java.util.ArrayList;
import java.util.List;

/***
 * 所得：在第15行的遍历过程中，需要从当前队列队尾往前遍历，不然队列一直在增加，
 * 最后会超时
 */
public class 格雷编码_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for(int i = 0;i<n;i++){
            for(int j = res.size() - 1; j >= 0; j--){
                res.add(head + res.get(j));
            }
            head = head << 1;
        }

        return res;
    }
}