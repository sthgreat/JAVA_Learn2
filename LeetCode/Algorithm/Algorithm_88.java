class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int pin1 = 0;
        int pin2 = 0;
        int num = 0;
        while(pin1 < m && pin2 < n){
            if(nums1[pin1] >= nums2[pin2]){
                arr[num] = nums2[pin2];
                pin2 ++;
                num ++;
            }else{
                arr[num] = nums1[pin1];
                pin1 ++;
                num ++;
            }
        }
        while(pin1 < m){
            arr[num] = nums1[pin1];
            num++;
            pin1++;
        }
        while(pin2 < n){
            arr[num] = nums2[pin2];
            num++;
            pin2++;
        }
        for(int j = 0; j < m+n;j++){
            nums1[j] = arr[j];
        }
    }
}