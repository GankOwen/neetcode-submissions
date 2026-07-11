class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
        boolean isEnd;
    }
    
    private TrieNode root;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        this.root = buildTrie(words);
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i, j, board, root, ans);
            }
        }
        return ans;
    }

    private void dfs (int row, int col, char[][] board, TrieNode node, List<String>ans){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#') return;
        char c = board[row][col];
        int index = c - 'a';
        TrieNode next = node.children[index];
        if(next == null) return;
        if(next.isEnd){
            ans.add(next.word);
            next.isEnd = false;
        }
        board[row][col] = '#';
        for(int[] d : this.directions){
            int newRow = row + d[0];
            int newCol = col + d[1];
            dfs(newRow, newCol, board, next, ans);
        }
        board[row][col] = c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode node = new TrieNode();
        for(String word : words){
            TrieNode n = node;
            for(char c : word.toCharArray()){
                int index = c-'a';
                if(n.children[index] == null){
                    n.children[index] = new TrieNode();
                }
                n = n.children[index];
            }
            n.isEnd = true;
            n.word = word;
        }
        return node;
    }
}
