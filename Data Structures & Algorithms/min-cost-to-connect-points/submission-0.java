class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] used = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int ans = 0;
        for(int i = 0; i < n; i++){
            // 1) 选取未使用且 dist 最小的点
            int u = -1;
            for(int v = 0; v < n; v++){
                if(!used[v] && ( u==-1||dist[v] < dist[u])) u = v;
            }
            used[u] = true;
            ans += dist[u];// 起点 dist[0]=0，不影响

            // 2) 用 u 来松弛其他未加入点
            for(int v = 0; v < n; v++){
                if(!used[v]){
                    int w = Math.abs(points[u][0] - points[v][0]) +
                            Math.abs(points[u][1] - points[v][1]);
                    if(w < dist[v]) dist[v] = w;
                }
            }
        }
        return ans;
    }
}
