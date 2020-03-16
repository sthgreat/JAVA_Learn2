package Niuke;

/***
 *二叉搜索树的后序遍历序列：
 * 后序遍历中，最后的节点为区分左子树与右子树的中点，
 * 右子树所有节点均大于中点
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLie {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0 || sequence == null){
            return false;
        }
        return isSequenceOfBST(sequence, 0, sequence.length-1);
    }

    private boolean isSequenceOfBST(int[] sequence, int start, int end){
        if(start >= end){
            return true;
        }
        int root = sequence[end];
        int flag = start;
        for(int i = start; i <= end; i++){
            if(sequence[i] < root){
                flag ++;
            }else{
                break;
            }
        }
        for(int i = flag; i <= end; i++){
            if(sequence[i] < root){
                return false;
            }
        }
        return isSequenceOfBST(sequence, start, flag-1) && isSequenceOfBST(sequence,flag,end-1);
    }
}