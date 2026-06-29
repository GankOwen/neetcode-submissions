class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[]val = new int[n+2];
        val[0] = 1;
        val[n+1] = 1;
        for(int i = 1; i <= n; i++){
            val[i] = nums[i-1];
        }

        int len = n+2;
        int[][]dp = new int[len][len];
        for(int range = 2; range < len; range++){
            for(int i = 0; i + range < len; i++){
                int j = i + range;
                for(int k = i+1; k < j; k++){
                    int coins = dp[i][k] + dp[k][j] + val[i] * val[k] * val[j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[0][len-1];
    }
}
