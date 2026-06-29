class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        int[] counts = new int[26];
        for(char c : tasks){
            int cur = c - 'A';
            counts[cur]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int cur : counts){
            if(cur > 0) pq.offer(cur);
        }

        int time = 0;
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

            time += pq.isEmpty() ? run : n+1;
        }
        return time;
    }
}
