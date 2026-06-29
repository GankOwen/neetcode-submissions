class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0; i <= n; i++){
            int cur = (i==n) ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= cur){
                int h = heights[st.pop()];
                int leftSmallerIndex = st.isEmpty() ? -1 : st.peek();
                int width =  i - leftSmallerIndex  - 1;
                maxArea = Math.max(maxArea,  h*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
 