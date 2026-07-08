class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, new ArrayList<>(), target, 0, ans);
        return ans;
    }
    private void dfs(int[] nums, List<Integer> path, int target, int start, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;

            path.add(nums[i]);
            dfs(nums, path, target - nums[i], i+1, ans);

            path.remove(path.size() - 1);
        }
    }
}
