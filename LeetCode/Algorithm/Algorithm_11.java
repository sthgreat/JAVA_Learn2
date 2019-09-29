package Algorithm;

public class Algorithm_11 {
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            for(int i = 0;i<height.length;i++){
                for(int j = 0;j<height.length;j++){
                    if(i == j){
                        continue;
                    }
                    int area = 0;
                    if(height[i]<height[j]){
                        area = height[i]*(Math.abs(i-j));
                    }else{
                        area = height[j]*(Math.abs(i-j));
                    }
                    max = (max>area)?max:area;
                }
            }
            return max;
        }
    }
}
