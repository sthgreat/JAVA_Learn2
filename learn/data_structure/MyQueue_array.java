package data_structure;

public class MyQueue_array {
    private int size;
    private Object[] array;
    private int start;
    private int end;

    public MyQueue_array(int init_size) {
        this.array = new Object[init_size];
        this.start = 0;
        this.end = 0;
        this.size = 0;
    }

    public boolean isFull(){
        return size == array.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Object o){ //在队尾添加元素
        if(isFull()){
            System.out.println("队列已满！");
            throw new IndexOutOfBoundsException();
        }
        if(this.end == array.length){
            this.end = 0;
        }
        array[end++] = o;
        size++;
    }

    public Object get(){ //在队头获得元素，同时删除
        if(isEmpty()){
            System.out.println("队列是空的！，返回null");
            return null;
        }
        if(this.start == array.length){
            this.start = 0;
        }
        Object result = array[start];
        array[start++] = null;
        size -- ;
        return result;
    }

    public void show(){ //输出队列内容
        int flag = this.start;
        while(flag!=this.end){
            if(flag == array.length){
                flag = 0;
                System.out.print(array[flag].toString()+" ");
                flag ++;
            }else {
                System.out.print(array[flag].toString()+" ");
                flag ++;
            }
        }
    }

    public static void main(String[] args){
        MyQueue_array myQueue_array = new MyQueue_array(3);
        myQueue_array.add(1);
        myQueue_array.add(2);
        myQueue_array.add(3);
        myQueue_array.get();
        myQueue_array.add(5);
        myQueue_array.show();
    }
}
