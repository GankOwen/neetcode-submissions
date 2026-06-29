class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftPro = new int[n];
        int[] rightPro = new int[n];

        leftPro[0] = 1;
        rightPro[n-1] = 1;
        for(int i = 1; i < n; i++){
            leftPro[i] = leftPro[i-1] * nums[i-1];
        }
        for(int j = n-2; j >= 0; j--){
            rightPro[j] = rightPro[j+1] *nums[j+1];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = leftPro[i] * rightPro[i];
        }
        return ans;
    }
}  
