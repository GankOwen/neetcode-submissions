class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    deque.offer(new int[]{i,j});
                }
            }
        }
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int r = cur[0], c = cur[1];
            for(int d[] : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == -1 || grid[nr][nc] <= grid[r][c]+1){
                    continue;
                }
                deque.offer(new int[]{nr, nc});
                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
}
