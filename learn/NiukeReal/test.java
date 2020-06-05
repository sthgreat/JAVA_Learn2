package NiukeReal;

public class test {
    public static void main(String[] args){
        test t = new test();
        System.out.println(t.longestPalindrome("abbac"));
    }
    public String longestPalindrome(String s) {
        boolean[][] record = new boolean[s.length()][s.length()];
        int start = 0;
        int size = 1;
        for(int i = 0;i<record.length;i++){
            for(int j = 0;j<=i;j++){
                if( i == j){
                    record[j][i] = true;
                    continue;
                }
                if(s.charAt(j) == s.charAt(i)){
                    if(j + 1 == i){ //字串长度为2
                        record[j][i] = true;
                        if(size < 2){
                            start = j;
                            size = 2;
                        }
                    }else{//字串长度大于2
                        if(record[j+1][i-1]){
                            record[j][i] = true;
                            if(size < i - j + 1){
                                size = i - j + 1;
                                start = j;
                            }
                        }
                    }
                }
            }
        }
        return s.substring(start, start + size);
    }
}