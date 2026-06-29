class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // ⚠️ 必须排序，否则无法识别重复
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path)); // 每个节点都是一个子集

        for (int i = start; i < nums.length; i++) {
            // 🚫 同层去重：跳过相邻相同的数字
            if (i > start && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);
            dfs(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
