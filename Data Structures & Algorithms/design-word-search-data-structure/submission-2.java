class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c -'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode cur){
        if(cur == null) return false;
        if(index == word.length()) return cur.isEnd;
        char c = word.charAt(index);
        
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(dfs(word, index+1, cur.children[i])){
                    return true;
                }
            }
            return false;
        }else{
            return dfs(word, index + 1, cur.children[c - 'a']);
        }
    }
}
