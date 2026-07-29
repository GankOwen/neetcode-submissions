class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // P + N = S
        // P - N = T
        // 2P = S + T
        // P = (S + T) / 2;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(Math.abs(target) > sum){
            return 0;
        }

        if((sum + target) % 2 != 0){
            return 0;
        }

        int amount = (sum + target) / 2;
        int n = nums.length;
        int[][] dp = new int[n+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            int num = nums[i-1];
            for(int j = 0; j <= amount; j++){
                dp[i][j] += dp[i-1][j];
                if(j >= num){
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[n][amount];
    }
}
