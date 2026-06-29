class Solution {
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length; 
        this.n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for(int c = 0; c < n; c++){
            dfs(0, c, pac, heights);
        }
        for(int r = 0; r < m; r++){
            dfs(r, 0, pac, heights);
        }

        for(int c = 0; c < n; c++){
            dfs(m-1, c, atl, heights);
        }

        for(int r = 0; r < m; r++){
            dfs(r, n-1, atl, heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pac[r][c] && atl[r][c]) ans.add(Arrays.asList(r, c));
            }
        }
        return ans;
    }

    private void dfs(int r, int c, boolean[][] vis, int[][] h){
        if(vis[r][c]) return;
        vis[r][c] = true;
        for(int[] d : dirs){
            int nr = r + d[0], nc = c + d[1];
            if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if(!vis[nr][nc] && h[nr][nc] >= h[r][c]){
                dfs(nr, nc, vis, h);
            }
        }
    }
}
