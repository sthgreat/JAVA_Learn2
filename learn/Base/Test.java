package Base;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Test t= new Test();
        System.out.println(t.ReverseSentence("student. a am I"));
    }

    public String ReverseSentence(String str) {
        if(str.length()==0){
            return str;
        }
        String[] line = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = line.length - 1;i>=0;i--){
            sb.append(line[i]).append(" ");
        }
        return sb.toString();
    }
}