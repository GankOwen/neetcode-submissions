class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[32];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int f : freq){
            if(f > 0) pq.offer(f);
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int run = 0;
            List<Integer> used = new ArrayList<>();
            for(int i = 0; i < n+1; i++){
                if(!pq.isEmpty()){
                    int cur = pq.poll();
                    run++;
                    if(cur - 1 > 0){
                        used.add(cur-1);
                    }
                }
            }
            for(int rest : used){
                pq.offer(rest);
            }
            ans += pq.isEmpty() ? run : n+1;
        }
        return ans;
    }
}
