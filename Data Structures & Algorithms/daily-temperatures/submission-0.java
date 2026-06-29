class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i] ){
                int cur = deque.pop();
                ans[cur] =  i - cur;
            }
            deque.push(i);
        }
        while(!deque.isEmpty()){
            ans[deque.pop()] = 0;
        }
        return ans;
    }
}
