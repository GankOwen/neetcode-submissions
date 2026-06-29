class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Map<String, List<String>> patternMap = new HashMap<>();
        int L = beginWord.length();

        for(String word : wordList){
            for(int i = 0; i < L; i++){
                String pattern = word.substring(0, i) + '*' + word.substring(i+1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();

            for(int i = 0; i < L; i++){
                String pattern = word.substring(0, i) + '*' + word.substring(i+1);
                for(String next : patternMap.getOrDefault(pattern, new ArrayList<>())){
                    if(next.equals(endWord)) return level + 1;
                    if(!visited.contains(next)){
                        visited.add(next);
                        queue.add(new Pair<>(next, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
