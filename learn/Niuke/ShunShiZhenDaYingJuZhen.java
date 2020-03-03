package Niuke;

import java.util.ArrayList;

public class ShunShiZhenDaYingJuZhen {
    public static void main(String[] args){
        int[][] a = new int[][]{{1,2},{3,4}};
        ShunShiZhenDaYingJuZhen s = new ShunShiZhenDaYingJuZhen();
        ArrayList<Integer> integers = s.printMatrix(a);
        System.out.print(integers.toString());
    }

    public  ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix.length == 0){
            return null;
        }
        int totalNum = matrix.length * matrix[0].length;
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int current_x = 0;
        int current_y = 0;
        int preTop = top;
        for(int i = 0; i < totalNum; i++){
            if(current_x == left && current_y == top){//左上角
                result.add(matrix[current_y][current_x]);
                current_x ++;
                if(preTop != top){//外圈遍历完成，需要修改left值
                    left --;
                    preTop = top;
                }
            }else if(current_x < right && current_y == top){//上边框
                result.add(matrix[current_y][current_x]);
                current_x++;
            }else if(current_x == right && current_y == top){//右上角
                result.add(matrix[current_y][current_x]);
                current_y ++;
                top++;
            }else if(current_x == right && current_y < bottom){//右边框
                result.add(matrix[current_y][current_x]);
                current_y ++;
            }else if(current_x == right && current_y == bottom){//右下角
                result.add(matrix[current_y][current_x]);
                current_x --;
                right--;
            }else if(current_x > left && current_y == bottom){//下边框
                result.add(matrix[current_y][current_x]);
                current_x --;
            }else if(current_x == left && current_y == bottom){//左下角
                result.add(matrix[current_y][current_x]);
                current_y --;
                bottom --;
            }else if(current_x == left && current_y > top){//左边框
                result.add(matrix[current_y][current_x]);
                current_y --;
            }
        }
        return result;
    }
}
