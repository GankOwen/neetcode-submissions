class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum < Math.abs(target)) return 0;
        // P + N = S
        // P - N = T
        // 2P = S + T
        if(((sum + target) & 1) == 1) return 0;
        int P = (sum + target)/2;

        int[][]dp = new int[n+1][P+1];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++){
            int num = nums[i-1];
            for(int j = 0; j <=P; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= num){
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[n][P];
    }
}
