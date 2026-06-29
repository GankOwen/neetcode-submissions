class Solution {
    public int maxProduct(int[] nums) {
        int minEnd = nums[0];
        int maxEnd = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            int x = nums[i];
            if(x < 0){
                int temp = maxEnd;
                maxEnd = minEnd;
                minEnd = temp;
            }
            maxEnd = Math.max(x, maxEnd * x);
            minEnd = Math.min(x, minEnd * x);
            ans = Math.max(ans, maxEnd);       
        }
        return ans;
    }
}
