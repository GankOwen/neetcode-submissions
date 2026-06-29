class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0; i < r; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < c; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j]) || board[i][j] < '1' || board[i][j] > '9') return false;
                set.add(board[i][j]);
            }
        }

        for(int j = 0; j < c; j++){
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < r; i++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j]) || board[i][j] < '1' || board[i][j] > '9') return false;
                set.add(board[i][j]);
            }
        }

        for(int boxRow = 0; boxRow < 3; boxRow++){
            for(int boxCol = 0; boxCol < 3; boxCol++){
                Set<Character> set = new HashSet<>();
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char cur = board[boxRow * 3 + i][boxCol * 3 + j];
                        if(cur=='.') continue;
                        if(set.contains(cur) || cur > '9' || cur < '1'){
                            return false;
                        }
                        set.add(cur);
                    }
                }
            }
        }
        return true;
    }
}
