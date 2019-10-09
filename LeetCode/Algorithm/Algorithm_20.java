package Algorithm;

import java.util.HashMap;
import java.util.Stack;

public class Algorithm_20 {
    /**
     * 使用栈的思路来实现
     */
    class Solution {
        public boolean isValid(String s) {
            if(s.equals("")){
                return true;
            }
            Stack<Character> stack = new Stack<Character>();
            HashMap<Character,Character> map = new HashMap<Character,Character>();
            map.put('(',')');
            map.put('{','}');
            map.put('[',']');
            for(int i = 0;i<s.length();i++){
                char ch = s.charAt(i);
                if(map.containsKey(ch)){
                    stack.push(ch);
                }else{
                    if(!stack.empty() && map.get(stack.peek()).equals(ch)){  //如果堆顶的元素与该元素匹配，删除堆顶元素，继续
                        stack.pop();
                        continue;
                    }else{
                        return false;
                    }

                }
            }
            if(stack.empty()){
                return true;
            }else{
                return false;
            }
        }
    }
}
