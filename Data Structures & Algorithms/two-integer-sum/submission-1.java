class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> records = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            
            if(records.containsKey(nums[i])){
                return new int[]{records.get(nums[i]), i};
            }else{
                int dif=  target - nums[i];
                records.put(dif, i);
            }
        }
        return new int[]{-1, -1};
    }
}
