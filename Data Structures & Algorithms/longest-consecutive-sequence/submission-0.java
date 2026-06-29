class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> records = new HashSet<>();
        for(int i : nums){
            records.add(i);
        }
        int ans = 0;
        for(int record : records){
            if(!records.contains(record -1)){
                int cur = 1;
                int add = 1;
                while(records.contains(record+add)){
                    cur++;
                    add++;
                }
                ans = Math.max(ans,cur);
            }
        }
        return ans;
    }
}
