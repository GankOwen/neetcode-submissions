class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> records = new HashSet<>();
        for(int i : nums){
            if(records.contains(i)){
                return true;
            }
            records.add(i);
        }
        return false;
    }
}