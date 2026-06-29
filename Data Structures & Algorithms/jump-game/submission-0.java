class Solution {
    public boolean canJump(int[] nums) {
        int curFar = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > curFar) return false;
            curFar = Math.max(curFar, i + nums[i]);
        }
        return true;
    }
}
