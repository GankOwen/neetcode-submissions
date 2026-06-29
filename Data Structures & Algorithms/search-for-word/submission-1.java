class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][]board, String word, int index, int r, int c){
        if(index == word.length()) return true;

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)){
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        boolean result = backtrack(board, word, index+1, r+1, c)
                    || backtrack(board, word, index+1, r-1, c)
                    || backtrack(board, word, index+1, r, c+1)
                    || backtrack(board, word, index+1, r, c-1);
        board[r][c] = temp;
        return result;
    }
}
