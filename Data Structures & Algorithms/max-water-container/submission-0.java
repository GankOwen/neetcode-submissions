class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n-1;
        int ans = 0;
        while(left < right){
            int height = Math.min(heights[left], heights[right]);
            int area = (right - left) * height;
            ans = Math.max(area, ans);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
