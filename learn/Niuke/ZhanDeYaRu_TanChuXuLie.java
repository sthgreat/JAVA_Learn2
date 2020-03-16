package Niuke;
import java.util.ArrayList;
import java.util.Stack;

/***
 * 模拟整个栈压入与弹出的过程，最后栈为空即视为成功
 */
public class ZhanDeYaRu_TanChuXuLie {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        for(int i = 0; i< pushA.length; i++){
            stack.push(pushA[i]);
            if(stack.peek().equals(Integer.valueOf(popA[flag]))){
                stack.pop();
                flag ++;
            }
        }
        for(int i = flag; i< popA.length;i++){
            if(stack.peek().equals(Integer.valueOf(popA[i]))){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
