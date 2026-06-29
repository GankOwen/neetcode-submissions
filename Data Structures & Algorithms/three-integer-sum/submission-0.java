class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n-2; i++){
            int left = i + 1, right = n-1;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] + nums[i+1] + nums[i+2] > 0) break;
            if(nums[i] + nums[n-2]+ nums[n-1] < 0) continue;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right])); 
                    int lv = nums[left], rv = nums[right];
                    while(left < right && lv == nums[left]) left++;
                    while(left < right && rv == nums[right]) right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}
