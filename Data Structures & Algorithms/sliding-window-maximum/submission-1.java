class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[]ans = new int[n-k+1];
        int index = 0;
        for(int r = 0; r < n; r++){
            if(!deque.isEmpty() && r-k >= deque.peekFirst()){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]){
                deque.pollLast();
            }
            deque.offerLast(r);
            if(r >= k-1){
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}

// 1. head index not in window size k, r-k >= head (k is 1-index) and deque not empty, poll; 
// 2. while add new num, smaller on left and deque not empty, poll out;
// 3. r >= k-1 we can add the ans;