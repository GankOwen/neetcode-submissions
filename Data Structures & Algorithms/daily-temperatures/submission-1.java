class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]){
                int index = deque.pollLast();
                ans[index] = i - index;
            }
            deque.offerLast(i);
        }
        ans[n-1] = 0;
        return ans;
    }
}
