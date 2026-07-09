class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean [nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, used, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, used, path, ans);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
