package data_structure;

import java.util.Arrays;

public class MyStack_Array {
    public Object[] stack;
    private int maxsize;
    private int size;
    private int top; //标记栈顶

    public static void main(String[] args){
        MyStack_Array s = new MyStack_Array(10);
        s.add(1);
        s.add(2);
        System.out.print(s.toString());
    }

    MyStack_Array(int initial_size){
        this.stack = new Object[initial_size];
        this.maxsize = initial_size;
        this.size = 0;
        this.top = -1;
    }

    private boolean needExpand(){
        return this.size + 1 > this.maxsize;
    }

    public Object get(){  //返回栈顶数据，同时删除
        if(this.size == 0){
            System.out.print("栈为空！");
            return null;
        }
        if(this.size < this.maxsize*3/4){
            this.stack = reduce();
        }
        Object result = this.stack[top];
        this.size --;
        this.top--;
        return result;
    }

    public void add(Object o){ //添加数据
        if(needExpand()){
            this.stack = expand();
        }
        if(this.size < this.maxsize/4){
            this.stack = reduce();
        }
        this.stack[++this.top] = o;
        this.size++;
    }

    private Object[] expand(){
        Object[] newStack = new Object[2*this.size];
        for(int i =0;i<this.size; i++){
            newStack[i] = this.stack[i];
        }
        return newStack;
    }

    private Object[] reduce(){
        Object[] newStack = new Object[this.maxsize/2];
        for(int i =0;i<this.size;i++){
            newStack[i] = this.stack[i];
        }
        return newStack;
    }

    @Override
    public String toString() {
        return "MyStack_Array{" +
                "stack=" + Arrays.toString(this.stack) +
                '}';
    }
}
