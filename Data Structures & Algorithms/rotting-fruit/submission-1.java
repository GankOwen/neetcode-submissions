class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Deque<int[]> deque = new ArrayDeque<>();

        // 先统计所有新鲜橘子，并加入所有腐烂橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        return bfs(grid, deque, fresh);
    }

    private int bfs(int[][] grid, Deque<int[]> deque, int fresh) {
        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int time = 0;

        while (!deque.isEmpty() && fresh > 0) {
            int[] cur = deque.poll();

            int r = cur[0];
            int c = cur[1];
            int curTime = cur[2];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= grid.length ||
                    nc < 0 || nc >= grid[0].length ||
                    grid[nr][nc] != 1) {
                    continue;
                }

                // 入队时立即标记，避免重复入队
                grid[nr][nc] = 2;
                fresh--;

                deque.offer(new int[]{nr, nc, curTime + 1});

                // 当前新腐烂橘子的时间
                time = Math.max(time, curTime + 1);
            }
        }

        return fresh == 0 ? time : -1;
    }
}