class Solution {
    static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    private TrieNode root;

    private TrieNode buildTrie(String[] words){
        for(String s : words){
            TrieNode cur = root;
            for(char c : s.toCharArray()){
                int index = c - 'a';
                if(cur.next[index] == null){
                    cur.next[index] = new TrieNode();
                }
                cur = cur.next[index];
            }
            cur.word = s;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        this.root = buildTrie(words);
        List<String> ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                dfs(board, r, c, root, ans);
            }
        }
        return ans;
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, List<String> ans){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        char ch = board[r][c];
        if(ch == '#') return;
        int index = ch - 'a';
        TrieNode next = node.next[index];
        if(next == null) return;
        if(next.word != null){
            ans.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';
        dfs(board, r + 1, c, next, ans);
        dfs(board, r - 1, c, next, ans);
        dfs(board, r, c + 1, next, ans);
        dfs(board, r, c - 1, next, ans);
        board[r][c] = ch;
    }

}
