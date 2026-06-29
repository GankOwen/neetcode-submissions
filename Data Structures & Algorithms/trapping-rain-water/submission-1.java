class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int cur = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int lHeight = height[left];
                int width = i - left - 1;
                int waterHeight = Math.min(height[left], height[i]) - height[cur];
                ans += waterHeight * width;
            }
            stack.push(i);
            
        }
        return ans;
    }
}
