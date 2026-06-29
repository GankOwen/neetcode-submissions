class Solution {
    private int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    private int m,n;
    private int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length == 0 || matrix[0].length == 0) return 0;

        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][]matrix, int i, int j){
        if(memo[i][j]!=0){
            return memo[i][j];
        }

        int best = 1;
        for(int[] d : dirs){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni < 0 || ni >= m || nj < 0 || nj >= n) continue;

            if(matrix[ni][nj] > matrix[i][j]){
                int candidate = 1 + dfs(matrix, ni, nj);
                best = Math.max(best, candidate);
            }
        }

        memo[i][j] = best;
        return best; 
    }
}
