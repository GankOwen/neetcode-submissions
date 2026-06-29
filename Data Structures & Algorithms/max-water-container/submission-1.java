class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n-1;
        int maxAmount = 0;
        while(l < r){
            int curAmount = Math.min(heights[l], heights[r]) * (r-l);
            maxAmount = Math.max(maxAmount, curAmount);
            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxAmount;
    }
}
