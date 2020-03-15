package Niuke;

import java.util.Stack;

public class BaoHan_min_HanShuDeZhan {
    public class Solution {
        private int min;
        Stack<Integer> normal = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        public void push(int node) {
            if(normal.size() == 0){
                min = node;
            }else{
                if(min > node){
                    min = node;
                }
            }
            normal.push(node);
        }

        public void pop() {
            normal.pop();
            int m = 0;
            if(normal.size() > 0){
                m = normal.peek();
            }
            while(normal.size()!=0){
                int num = normal.pop();
                if(num < m){
                    m = num;
                }
                temp.push(num);
            }
            min = m;
            while(temp.size()!=0){
                normal.push(temp.pop());
            }
        }

        public int top() {
            return normal.peek();
        }

        public int min() {
            return min;
        }
    }
}
