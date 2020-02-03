enum Index {
    GOOD, BAD, UNKNOWN
}

class Solution {
    public boolean canJump(int[] nums) {
        Index[] memory = new Index[nums.length];
        for(int i = 0;i<nums.length;i++){
            memory[i] = Index.UNKNOWN;
        }
        memory[nums.length - 1] = Index.GOOD;

        for(int i = nums.length - 2; i >=0; i--){
            for(int j = 0; j <= nums[i];j++){ // j为该单元格的跳步数
                if(memory[i+j] == Index.GOOD && i+j < nums.length){
                    memory[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memory[0] == Index.GOOD;
    }
}