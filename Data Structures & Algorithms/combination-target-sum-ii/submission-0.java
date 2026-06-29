class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // 可选，用于剪枝
        dfs(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int target, int start, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {                  // ✅ 找到一个解
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // 🔥 同层去重：跳过重复元素（只在同层生效）
            if (nums[i] > target) break;   // 🚫 剪枝：超过目标没必要继续
            path.add(nums[i]);             // 做选择
            dfs(nums, target - nums[i], i+1, path, ans); // 注意这里传 i，不是 i+1
            path.remove(path.size() - 1);  // 撤销选择
        }
    }
}
