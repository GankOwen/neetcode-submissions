class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }
    private int dfs(int[] nums, int index, int currentSum, int target){
        if(index == nums.length){
            return currentSum == target ? 1 : 0;
        }

        int add = dfs(nums, index+1, currentSum + nums[index], target);
        int subtract = dfs(nums, index+1, currentSum - nums[index], target);

        return add + subtract;
    }
}
