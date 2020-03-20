package Base;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<>();
        a.add("ab");
        if(a.contains("ab")){
            a.add("ba");
        }
        System.out.println(a.size());

    }
}
