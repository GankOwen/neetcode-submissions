class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>(); // row - col
        Set<Integer> diagonals2 = new HashSet<>();

        backtrack(0, n, board, cols, diagonals1, diagonals2, ans);
        return ans;
    }
    private void backtrack(int row, int n, char[][]board, Set<Integer> cols, Set<Integer> diagonals1,
                            Set<Integer> diagonals2, List<List<String>> ans){
        if(row == n){
            ans.add(buildBoard(board));
            return;
        }

        for(int col = 0; col < n; col++){
            int diagonal1 = row - col;
            int diagonal2 = row + col;

            if(cols.contains(col) || diagonals1.contains(diagonal1) || diagonals2.contains(diagonal2)){
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);

            backtrack(row+1, n, board, cols, diagonals1, diagonals2, ans);

            board[row][col] = '.';
            cols.remove(col);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    private List<String> buildBoard(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] row : board){
            result.add(new String(row));
        }
        return result;
    }
}
