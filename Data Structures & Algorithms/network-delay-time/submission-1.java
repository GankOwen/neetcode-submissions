class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            graph.computeIfAbsent(time[0], a -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> distances = new HashMap<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int source = cur[0];
            int weight = cur[1];
            if(distances.containsKey(source)) continue;
            distances.put(source, weight);
            List<int[]> neighbors = graph.get(source);
            for(int[] neighbor : graph.getOrDefault(source, new ArrayList<>())){
                int next = neighbor[0], cost = neighbor[1];
                if(!distances.containsKey(next)){
                    pq.offer(new int[]{next, weight+cost});
                }
            }
        }
        if(distances.size() < n) return -1;
        int ans = 0;
        for(int t : distances.values()){
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
