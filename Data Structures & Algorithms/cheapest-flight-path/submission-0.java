class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1_000_000_000;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for(int t = 0; t <= k; t++){
            int[] prev = dist.clone();
            for(int[] f : flights){
                int u = f[0], v = f[1], w = f[2];
                if(prev[u] == INF) continue;
                dist[v] = Math.min(dist[v], prev[u] + w);
            }
        }

        return dist[dst] >= INF ? -1 : dist[dst];
    }
}
