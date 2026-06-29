class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int target, int start, List<Integer> path, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(nums[i] > target) return;
            path.add(nums[i]);
            dfs(nums, target-nums[i], i, path, ans);
            path.remove(path.size()-1);
        }
    }
}
