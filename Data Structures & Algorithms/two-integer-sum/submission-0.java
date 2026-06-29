class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> records = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            int index = records.getOrDefault(difference, -1);
            if(index == -1){
                records.put(nums[i], i);
            }else{
                return ans = new int[] {index, i};
            }
        }
        return ans = new int[]{-1,-1};
    }
}
