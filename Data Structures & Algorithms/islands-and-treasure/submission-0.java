class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) { 
                    deque.offer(new int[]{r,c});  
                }
            }
        }
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int r = cur[0], c = cur[1];
            for(int[] d : dirs){
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if(0 <= nr && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != -1 && grid[nr][nc] > grid[r][c] + 1){
                    deque.offer(new int[]{nr,nc});
                    grid[nr][nc] = grid[r][c]+1;
                }
            }
        }
    }
}
