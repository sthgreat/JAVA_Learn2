package NiukeReal;

public class 求和 {
    public static void main(String[] args){
        System.out.println(deal(100000));
    }

    public static int deal(int target){
        int ans = 1;
        for(int i = 10;i<target;i++){
            String A = String.valueOf(i);
            for(int j = 0;j<A.length();j++){
                int n = Integer.parseInt(A.substring(0,j) + A.substring(j+1, A.length()));
                if(n + i == target){
                    ans ++;
                }
            }
        }

        return ans;
    }
}
