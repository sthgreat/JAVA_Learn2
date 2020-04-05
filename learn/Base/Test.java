package Base;

import java.util.ArrayList;

public class Test {
    c[] a;
    public static void main(String[] args){
        Test t = new Test();
        c c1 = new c(1);
        c c2 = new c(2);
        t.a = new c[]{c1, c2};
        System.out.println(t.a[0].toString());
        System.out.println(t.a[1].toString());
        t.swap();
        System.out.println(t.a[0].toString());
        System.out.println(t.a[1].toString());
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
