class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                board[i][0] = 'E';
                deque.offer(new int[]{i, 0});
            }
            if(n > 1 && board[i][n-1] == 'O'){
                board[i][n-1] = 'E';
                deque.offer(new int[]{i, n-1});
            }
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O'){
                board[0][j] = 'E';
                deque.offer(new int[]{0, j});
            }
            if(m > 1 && board[m-1][j] == 'O'){
                board[m-1][j] = 'E';
                deque.offer(new int[]{m-1, j});
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            for(int[]d : dirs){
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n || board[nr][nc] != 'O'){
                    continue;
                }
                board[nr][nc] = 'E';
                deque.offer(new int[]{nr, nc});
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'E'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
