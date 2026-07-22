class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] vis = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int time = cur[0], r = cur[1], c = cur[2];
            if(vis[r][c]) continue;
            vis[r][c] = true;
            if(r == n-1 && c == n-1){
                return time;
            }
            for(int[] dir : dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nr >= n || nc < 0 || nc >= n || vis[nr][nc]) continue;
                int nt = Math.max(time, grid[nr][nc]);
                pq.offer(new int[]{nt, nr, nc});
            }
        }
        return -1;
    }
}
