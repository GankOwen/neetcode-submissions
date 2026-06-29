class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        for(int i = 0; i <= n; i++){
            int cur =  i==n ? 0 : heights[i];
            while(!deque.isEmpty() && heights[deque.peekLast()] >= cur){
                int mid = deque.pollLast();
                int left = deque.isEmpty() ? -1 : deque.peekLast();
                int right = i;
                int width = right - left - 1;
                ans = Math.max(ans, width * heights[mid]);
            }

            deque.offerLast(i);
        }
        return ans;
    }
}
