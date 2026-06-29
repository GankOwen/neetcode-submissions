class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int rows = grid.length, cols = grid[0].length;


        // 遍历整个网格
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    res = Math.max(bfs(grid, r, c), res);    // 从这里开始BFS，把整座岛淹掉
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int r, int c) {
        int ans = 1;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // 四个方向
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0; // 标记访问过

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] d : dirs) {
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];
                // 合法坐标且是陆地
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 0; // 立即标记避免重复
                    ans++;
                }
            }
        }
        return ans;
    }
}
