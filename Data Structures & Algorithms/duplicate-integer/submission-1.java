class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> records = new HashMap<>();
        for(int i : nums){
            if(!records.containsKey(i)){
                records.put(i, 1);
            }else{
                return true;
            }
        }
        return false;
    }
}