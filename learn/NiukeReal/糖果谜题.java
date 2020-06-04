package NiukeReal;

import java.util.*;

/***
 * 利用一个map记录糖果分配情况，根据情况进行计算
 */
public class 糖果谜题 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap();
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        for(int i = 0;i<ss.length;i++){
            int key = Integer.valueOf(ss[i]);
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key , 1);
            }
        }
        int ans = 0;
        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            int num = map.get(key);
            if(key == 0){
                ans += num;
                continue;
            }
            if(num <= key + 1){
                ans += key + 1;
            }else{
                ans += (num/(key+1) + 1) * (key + 1);
            }
        }
        System.out.println(ans);
    }
}
