class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] vals = new int[n+2];
        vals[0] = 1; 
        vals[n+1] = 1;
        for(int i = 1; i < n+1; i++){
            vals[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int len = 1; len <= n; len++){
            for(int left = 1; left + len - 1 <= n; left++){
                int right = left + len - 1;
                for(int k = left; k <= right; k++){
                    int leftCoins = dp[left][k-1];
                    int rightCoins = dp[k+1][right];
                    int lastCoins = vals[left-1] * vals[k] * vals[right+1];

                    dp[left][right] = Math.max(leftCoins + lastCoins + rightCoins, dp[left][right]);
                }
            }
        }
        return dp[1][n];
    }
}
