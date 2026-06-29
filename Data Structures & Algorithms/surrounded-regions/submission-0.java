class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length; n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')      { board[i][0] = 'E';      q.offer(new int[]{i, 0}); }
            if (board[i][n-1] == 'O')    { board[i][n-1] = 'E';    q.offer(new int[]{i, n-1}); }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')      { board[0][j] = 'E';      q.offer(new int[]{0, j}); }
            if (board[m-1][j] == 'O')    { board[m-1][j] = 'E';    q.offer(new int[]{m-1, j}); }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[]d : dirs){
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];
                if(nr < 0 || nc < 0 || nr >= m || nc >=n) continue;
                if(board[nr][nc] == 'O'){
                    board[nr][nc] = 'E';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }
}
