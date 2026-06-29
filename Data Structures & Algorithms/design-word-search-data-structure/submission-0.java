class WordDictionary {
    private static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
    private final Node root ;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node n = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(n.next[index] == null){
                Node newNode = new Node();
                n.next[index] = newNode;
            }
            n = n.next[index];
        }
        n.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String s, int index, Node node){
        if(node == null) return false;
        if(index == s.length()) return node.isEnd;
        char c = s.charAt(index);
        if(c=='.'){
            for(int i = 0; i < 26; i++){
                if(node.next[i]!=null && dfs(s, index+1, node.next[i])){
                    return true;
                }
            }
            return false;
        }else{
            return dfs(s, index+1, node.next[c-'a']);
        }
    }
}
