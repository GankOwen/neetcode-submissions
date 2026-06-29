class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        
        // 1️⃣ 统计所有起点（烂橘子）并计数新鲜橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j, 0});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = 0;

        // 2️⃣ BFS 扩散
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], t = cur[2];
            minutes = Math.max(minutes, t);  // 记录当前层的时间

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (0 <= nr && nr < m && 0 <= nc && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;  // 新鲜变烂
                    fresh--;           // 新鲜数量减少
                    q.offer(new int[]{nr, nc, t + 1}); // 时间+1
                }
            }
        }

        // 3️⃣ 判断是否还有没烂的
        return fresh == 0 ? minutes : -1;
    }
}
