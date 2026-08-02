class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int ans = nums[0];
        for(int i = 1; i < n; i++){
            curMax = Math.max(nums[i], curMax + nums[i]);
            ans = Math.max(ans, curMax);
        }
        return ans;
    }
}
