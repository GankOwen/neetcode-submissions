class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), target, 0, ans);
        return ans;
    }

    private void dfs(int[] nums, List<Integer> path, int target, int start, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(path));
        }
        if(target < 0) return;

        for(int i = start; i < nums.length; i++){
            if(nums[i] > target) return;
            path.add(nums[i]);
            dfs(nums, path, target-nums[i], i, ans);
            path.remove(path.size()-1);
        }
    }
}
