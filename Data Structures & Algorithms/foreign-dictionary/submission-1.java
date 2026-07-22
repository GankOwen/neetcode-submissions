class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String first = words[i];
            String second = words[i+1];

            int minLength = Math.min(first.length(), second.length());
            int j = 0;
            while(j < minLength && first.charAt(j) == second.charAt(j)){
                j++;
            }
            if(j==minLength){
                if (first.length() > second.length()) {
                    return "";
                }
                continue;
            }
            char from = first.charAt(j);
            char to = second.charAt(j);
            if(graph.get(from).add(to)){
                indegree.put(to, indegree.get(to)+1);
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0){
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            char current = queue.poll();
            result.append(current);
            for(char neighbor : graph.get(current)){
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if(indegree.get(neighbor)==0){
                    queue.offer(neighbor);
                }
            }
        }
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}