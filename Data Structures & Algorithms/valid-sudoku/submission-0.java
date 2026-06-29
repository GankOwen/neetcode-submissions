class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            Set<Character> records = new HashSet<>();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                if(board[i][j] > '9' || board[i][j] < '1' || records.contains(board[i][j])){
                    return false;
                }
                records.add(board[i][j]);
            }
        }
        for(int j = 0; j < board.length; j++){
            Set<Character> records = new HashSet<>();
            for(int i = 0; i < board[0].length; i++){
                if(board[i][j] == '.') continue;
                if(board[i][j] > '9' || board[i][j] < '1' || records.contains(board[i][j])){
                    return false;
                }
                records.add(board[i][j]);
            }
        }

        for(int boxRow = 0; boxRow < 3; boxRow++){
            for(int boxCol = 0; boxCol < 3; boxCol++){
                Set<Character> records = new HashSet<>();
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char c = board[boxRow * 3 + i][boxCol * 3 + j];
                        if(c == '.') continue;
                        if(c > '9' || c < '1' || records.contains(c)){
                            return false;
                        }
                        records.add(c);
                    }
                }
            }
        }

        return true;
    }
}
