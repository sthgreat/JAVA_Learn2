package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;

/***
 * 利用栈数据结构来解释
 */
public class 逆波兰表达式_150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> MyStack = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(String s : tokens){
            if(!set.contains(s)){ //数字
                MyStack.addLast(Integer.valueOf(s));
            }else{
                int b = MyStack.removeLast();
                int a = MyStack.removeLast();
                if(s.equals("+")){
                    MyStack.addLast(a+b);
                }else if(s.equals("-")){
                    MyStack.addLast(a-b);
                }else if(s.equals("*")){
                    MyStack.addLast(a*b);
                }else{
                    MyStack.addLast(a/b);
                }
            }
        }
        return MyStack.removeLast();
    }
}