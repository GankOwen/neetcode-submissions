class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        dfs(nums, new ArrayList<>(), 0, ans);
        return ans;
    }
    private void dfs(int[] nums, List<Integer> path, int start, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);

            // 这里传 i，不是 i + 1
            // 因为同一个数字可以重复使用
            dfs(nums, path, i+1, ans);

            path.remove(path.size() - 1);
        }
    }
}
