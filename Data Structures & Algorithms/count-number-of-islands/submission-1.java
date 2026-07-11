class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int islands = 0;

         // 遍历整个网格
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;          // 找到一座新岛屿
                    bfs(grid, r, c);    // 从这里开始BFS，把整座岛淹掉
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int row, int col){
        int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{row, col});
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int r = cur[0], c = cur[1];
            grid[r][c] = '0';
            for(int[] d : dirs){
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == '0'){
                    continue;
                }
                deque.offer(new int[]{nr, nc});
            }
        }
    }
}
