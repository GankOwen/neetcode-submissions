class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int maxIslands = 0;

         // 遍历整个网格
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxIslands = Math.max(maxIslands, bfs(grid, r, c));    // 从这里开始BFS，把整座岛淹掉
                }
            }
        }

        return maxIslands;
    }

    private int bfs(int[][] grid, int row, int col){
        int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
        Deque<int[]> deque = new ArrayDeque<>();
        int area = 0;
        deque.offer(new int[]{row, col});
        grid[row][col] = 0;
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int r = cur[0], c = cur[1];
            area++;
            for(int[] d : dirs){
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == 0){
                    continue;
                }
                grid[nr][nc] = 0;
                deque.offer(new int[]{nr, nc});
            }
        }
        return area;
    }
}
