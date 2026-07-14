class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            dfs(i, 0, pacific, heights);
            dfs(i, cols-1, atlantic, heights);
        }

        for(int j = 0; j < cols; j++){
            dfs(0, j, pacific, heights);
            dfs(rows-1, j, atlantic, heights);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return ans;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights){
        visited[r][c] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length ||
             visited[nr][nc] ||heights[r][c] > heights[nr][nc]){
                continue;
             }
            dfs(nr, nc, visited, heights);
        }
    }
}
