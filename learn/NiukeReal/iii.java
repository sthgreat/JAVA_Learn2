package NiukeReal;

import java.util.LinkedList;
import java.util.Scanner;

public class iii {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
//        String num = sc.nextLine();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            list.add(s);
        }
//        System.out.println(Integer.valueOf(num));
        for(String sss : list){
            System.out.println(sss);
        }
    }
}
