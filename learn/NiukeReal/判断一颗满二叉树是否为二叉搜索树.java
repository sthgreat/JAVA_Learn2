package NiukeReal;
import java.util.*;

public class 判断一颗满二叉树是否为二叉搜索树 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nodes = n.split(",");
        if(isValid(nodes, 0, 0, true)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    public static boolean isValid(String[] nodes, int cur, int FatherV, boolean isLeftTree){
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        if(left >= nodes.length){ //当前节点无子节点
            return true;
        }
        //走到这说明双节点都在，先判断一下本节点是否满足条件
        int curValue = Integer.valueOf(nodes[cur]);
        int leftV = Integer.valueOf(nodes[left]);
        int rightV = Integer.valueOf(nodes[right]);
        if(isLeftTree){
            if(FatherV !=0 && rightV >= FatherV){
                return false;
            }
        }else{
            if(FatherV !=0 && leftV <= FatherV){
                return false;
            }
        }
        if(leftV < curValue && rightV > curValue){
            return isValid(nodes, left, curValue, true) && isValid(nodes, right, curValue, false);
        }else{
            return false;
        }
    }
}
