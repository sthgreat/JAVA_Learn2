class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = 0;
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            if(s.length()>length){
                length = s.length();
            }
        }
        boolean flag = true;
        for(int i = 0; i < length;i++){
            for(int j = 0; j<strs.length; j++){
                if(!(j+1 <strs.length &&(strs[j].charAt(i)).equal(strs[j+1].charAt[i]))){
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                break;
            }
            sb.append(strs[j].charAt(i));
        }
        return(sb+"");
    }
}