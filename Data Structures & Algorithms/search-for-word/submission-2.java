class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][]board, int r, int c, int index, String word){
        if(index == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length 
        ||board[r][c] != word.charAt(index)) return false;
        char temp = board[r][c];
        board[r][c] = '#';
        boolean result = dfs(board, r+1, c, index+1, word) 
        || dfs(board, r-1, c, index+1, word) 
        || dfs(board, r, c+1, index+1, word) 
        || dfs(board, r, c-1, index+1, word);
        board[r][c] = temp;
        return result;
    }
}
