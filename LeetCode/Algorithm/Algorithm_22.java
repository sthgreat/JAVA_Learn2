package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Algorithm_22 {
    /**
     * 回溯问题，需要掌握，还不太熟
     */
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> rs = new ArrayList<String>();
            generate(rs,n,"",0,0);
            return rs;
        }

        private void generate(List<String> rs, int n,String s,int left,int right){
            if(s.length()==2*n){
                rs.add(s);
                return;
            }
            if(left>right){
                generate(rs,n,s+")",left,right+1);
            }
            if(left<n){
                generate(rs,n,s+"(",left+1,right);
            }
        }
    }
}
