package Base;

import java.util.ArrayList;

public class Test {
    c[] a;
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.remove(0);
        System.out.println(arr.toString());
    }

    public void swap(){
        c temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }
}

class c{
    int value;

    @Override
    public String toString() {
        return "c{" +
                "value=" + value +
                '}';
    }

    public c(int value) {
        this.value = value;
    }
}
