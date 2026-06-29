class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, k = n-1;
            while(j < k){
                int curSum = nums[i] + nums[j] + nums[k];
                if( curSum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1] ){
                        j++;
                    }
                    while (j < k && nums[k+1] == nums[k]){
                        k--;
                    }
                }else if(curSum < 0){
                    j++;
                }else{
                    k--;
                }
                
            }
        }
        return ans;
    }
}
