class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int currentMax = nums[0];
        int currentMin = nums[0];

        int result = nums[0];

        int prevMax = nums[0];
        int prevMin = nums[0];

        for(int i = 1; i < n; i++){
            prevMax = currentMax;
            prevMin = currentMin;
            int cur = nums[i];

            currentMax = Math.max(cur, Math.max(prevMax * nums[i], prevMin * cur));
            currentMin = Math.min(cur, Math.min(prevMax * nums[i], prevMin * cur));

            result = Math.max(result, currentMax);
        }

        return result;
    }
}
