class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int[] maxDp = new int[n];
        int[] minDp = new int[n];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        int result = nums[0];

        for(int i = 1; i < n; i++){
            int cur = nums[i];

            maxDp[i] = Math.max(cur, Math.max(maxDp[i-1] * nums[i], minDp[i-1] * cur));
            minDp[i] = Math.min(cur, Math.min(maxDp[i-1] * nums[i], minDp[i-1] * cur));

            result = Math.max(result, maxDp[i]);
        }

        return result;
    }
}
