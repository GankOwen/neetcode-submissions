class Solution {
    public int jump(int[] nums) {
        int curFar = 0;
        int step = 0;
        int maxFar = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxFar = Math.max(maxFar, nums[i] + i);
            if(i == curFar){
                step++;
                curFar = maxFar;
            }
        }
        return step;
    }
}
