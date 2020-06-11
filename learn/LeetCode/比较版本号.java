package LeetCode;

/***
 *
 */
public class 比较版本号 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while(index1 < v1.length && index2 < v2.length){
            int num1 = Integer.valueOf(v1[index1]);
            int num2 = Integer.valueOf(v2[index2]);
            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }else{
                index1 ++;
                index2 ++;
            }
        }
        if(index1 < v1.length){
            for(int i = index1;i<v1.length;i++){
                int num1 = Integer.valueOf(v1[i]);
                if(num1 > 0){
                    return 1;
                }
            }
        }

        if(index2 < v2.length){
            for(int i = index2;i<v2.length;i++){
                int num2 = Integer.valueOf(v2[i]);
                if(num2 > 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
