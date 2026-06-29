class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int start, int[] nums, List<Integer> path, List<List<Integer>> ans){
        ans.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            dfs(i+1, nums, path, ans);
            path.remove(path.size()-1);
        }
    }
}
