class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = Math.max(grid[0][0], grid[n-1][n-1]);
        int hi = n * n - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (canReach(grid, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean canReach(int[][] grid, int t) {
        int n = grid.length;
        if (grid[0][0] > t) return false;
        boolean[][] vis = new boolean[n][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == n - 1 && c == n - 1) return true;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (!vis[nr][nc] && grid[nr][nc] <= t) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
