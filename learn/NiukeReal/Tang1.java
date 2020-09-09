package NiukeReal;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 订单系统工作流路径解析
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 1. 背景: 订单系统的业务逻辑处理，通过采用工作流的方式进行处理，基于面向配置编程以利于后续扩展与维护.
 *
 * 2. 要求: 当前需要根据工作流的配置解析和找出所有工作流路径, 可能存在循环依赖路径.
 *
 * 3. 说明: 空格隔开的字符串每一个字母都代表一个节点. 比如a bc e, 表示a的下一个节点为b或者c， 输出为:abe, ace.
 * 4. 举例: 有3个分支，
 *             输入a bc df gh
 *             输出如下， 结果输出根据单个字符的下标index排序:  Comparator.naturalOrder().
 *                  abdg
 *                  abdh
 *                  abfg
 *                  abfh
 *                  acdg
 *                  acdh
 *                  acfg
 *                  acfh
 *
 */

public class Tang1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        find(ss, 0, new StringBuilder());
    }

    public static void find(String[] s, int curIndex, StringBuilder sb){
        if(curIndex >= s.length){
            if(isRepeat(sb.toString())){
                System.out.println(sb.toString() + " -dependency");
            }else{
                System.out.println(sb.toString());
            }
            return;
        }


        for(int i = 0;i<s[curIndex].length();i++){
            sb.append(s[curIndex].charAt(i));
            find(s, curIndex+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isRepeat(String s){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < s.length();i++){
            if(set.contains(s.charAt(i))){
                return true;
            }
            set.add(s.charAt(i));
        }
        return false;
    }
}
