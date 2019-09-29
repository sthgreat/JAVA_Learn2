package Algorithm;

public class Algorithm_11 {
    /**
     * 思路：规定两个指针，从两侧开始，将最短的那个指针向中间移动，使用一个定值保存
     * 面积大小，每一轮进行比较，留下最大的那个。
     * 可行性：长度也是制约因素，开始取长度最长，记录下一个值，当长度缩小时，需要修改当前
     * 最短的那条边，向中间移动，以求获得一个长边，面积大于最大的面积
     */
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
