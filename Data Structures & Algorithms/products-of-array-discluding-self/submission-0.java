class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        leftToRight[0] = 1;
        rightToLeft[n-1] = 1;
        for(int i = 1; i < n; i++){
            leftToRight[i] = nums[i-1] * leftToRight[i-1];
        } // 1 1 2 8
        for(int j = n-2; j >= 0; j--){
            rightToLeft[j] = nums[j+1] * rightToLeft[j+1];
        } //  48  24  6 1
        int[] ans = new int[n];
        for(int k= 0; k < n; k++){
            ans[k] = leftToRight[k] * rightToLeft[k];
        }
        return ans;
    }
}  
