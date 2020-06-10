package LeetCode;

import java.util.LinkedList;

/***
 * 利用栈的特性，使用辅助栈记录最小值，辅助栈与存储栈等量
 */
class MinStack {
    LinkedList<Integer> help;
    LinkedList<Integer> store;

    /** initialize your data structure here. */
    public MinStack() {
        help = new LinkedList<>();
        store = new LinkedList<>();
    }

    public void push(int x) {
        if(store.size() == 0){
            store.addLast(x);
            help.addLast(x);
        }else{
            store.addLast(x);
            int temp = help.getLast();
            if(temp > x){
                help.addLast(x);
            }else{
                help.addLast(temp);
            }
        }
    }

    public void pop() {
        if(store.size() == 0){
            return;
        }
        help.removeLast();
        store.removeLast();
    }

    public int top() {
        if(store.size() == 0){
            return 0;
        }else{
            return store.getLast();
        }
    }

    public int getMin() {
        if(store.size() == 0){
            return 0;
        }else{
            return help.getLast();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
