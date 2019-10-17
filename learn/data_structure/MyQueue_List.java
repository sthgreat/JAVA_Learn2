package data_structure;

public class MyQueue_List { //暂时先构建单向链表
    private my_Node head;
    private my_Node pin;
    private int size;

    public MyQueue_List(){
        this.size = 0;
    }

    public void add(Object o){
        if(head == null){
            head = new my_Node(null,null,o);
            pin = head;
        }else {
            my_Node temp = pin;
            pin = new my_Node(temp,null,o);
            temp.setBack(pin);
        }
    }

    public Object get(){ //获取头
        if(head == null){
            System.out.print("队列是空的！");
            return null;
        }else{
            Object result = head.getValue();
            head.getBack().setFront(null);
            head = head.getBack();
            return result;
        }
    }

    public void show(){
        my_Node m = head;
        while(m != null){
            System.out.print(m.getValue().toString()+ " ");
            m = m.getBack();
        }
    }

    public static void main(String[] args){
        MyQueue_List l = new MyQueue_List();
        l.add(1);
        l.add(2);
        l.get();
        l.add(3);
        l.show();
    }
}

class my_Node{
    private my_Node front;
    private my_Node back;
    private Object value;

    public my_Node(my_Node front, my_Node back, Object value) {
        this.front = front;
        this.back = back;
        this.value = value;
    }

    public my_Node getFront() {
        return front;
    }

    public void setFront(my_Node front) {
        this.front = front;
    }

    public my_Node getBack() {
        return back;
    }

    public void setBack(my_Node back) {
        this.back = back;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
