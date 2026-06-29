class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times){
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(
                new int[]{edge[1],edge[2]}
            );
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        Map<Integer, Integer> distances = new HashMap<>();

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int time = cur[0], node = cur[1];

            if(distances.containsKey(node)) continue;

            distances.put(node, time);

            if(graph.containsKey(node)){
                for(int[] nei : graph.get(node)){
                    int next = nei[0], wt = nei[1];
                    if(!distances.containsKey(next)){
                        pq.offer(new int[]{time + wt, next});
                    }
                }
            }
        }

        if(distances.size() < n) return -1;
        int ans = 0; 
        for(int t: distances.values()) ans = Math.max(t, ans);
        return ans;
    }
}
