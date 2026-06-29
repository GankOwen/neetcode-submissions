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

        int[]dp = new int[P+1];
        dp[0] = 1;

        for(int num: nums){
            for(int j = P; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[P];
    }
}
