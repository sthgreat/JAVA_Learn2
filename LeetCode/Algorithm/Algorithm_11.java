package Algorithm;

public class Algorithm_11 {
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int i =0;
            int j = height.length - 1;
            while(i<j){
                int h = height[i]>height[j]?height[j]:height[i];
                int area = (h*(Math.abs(i-j)));
                max = max>area? max: area;
                if(height[i]<height[j]){
                    i++;
                }else{
                    j--;
                }
            }
            return max;
        }
    }
}
