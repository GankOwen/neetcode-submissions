class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                String cur = queue.poll();
                if(cur.equals(endWord)) return level;
                char[] word = cur.toCharArray();
                for(int i = 0; i < word.length; i++){
                    char originalChar = word[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == originalChar) continue;
                        word[i] = c;
                        String nextWord = new String(word);
                        if(words.contains(nextWord)){
                            queue.offer(nextWord);
                            words.remove(nextWord);
                        }
                    }
                    word[i] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
