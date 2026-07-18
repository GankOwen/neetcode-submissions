class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!wordList.contains(endWord)) return 0;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int level = 1;

        words.remove(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                if(current.equals(endWord)){
                    return level;
                }
                char[] chars = current.toCharArray();
                for(int j = 0; j < chars.length;j++){
                    char original = chars[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c==original){
                            continue;
                        }

                        chars[j] = c;
                        String nextWord = new String(chars);
                        if(words.contains(nextWord)){
                            queue.offer(nextWord);
                            words.remove(nextWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
    
}
