package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class test {
    static ArrayList<String> ans;
    public static void main(String[] args){
        String s = "0000";
        test t = new test();
        System.out.println(t.restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        traceback(s,"",0,0);
        return ans;
    }

    private void traceback(String originS, String DealingS,int startIndex,int cutCount){
        if(cutCount == 3 && startIndex<originS.length()){
            if(originS.length() - startIndex <= 3){
                ans.add(DealingS + originS.substring(startIndex));
            }
            return;
        }
        if(startIndex >= originS.length()){
            return;
        }
        for(int i = 1; i <4 && startIndex + i <= originS.length();i++){
            int num = startIndex + i;
            String s = originS.substring(startIndex,num);
            int stringNum = Integer.parseInt(s);
            if(s.length() != String.valueOf(stringNum).length()){
                continue;
            }
            if(stringNum >= 0 && stringNum<256){
                traceback(originS, DealingS + s + ".",num,cutCount+1);
            }
        }
    }
}
