class Solution {
    public String foreignDictionary(String[] words) {
        // 1) Collect all unique letters
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indeg.putIfAbsent(c, 0);
            }
        }

        // 2) Build edges from adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];

            // Prefix invalid: "abc" before "ab"
            if (a.length() > b.length() && a.startsWith(b)) return "";

            int len = Math.min(a.length(), b.length());
            for (int j = 0; j < len; j++) {
                char ca = a.charAt(j), cb = b.charAt(j);
                if (ca != cb) {
                    // ca must come before cb: ca -> cb
                    // Avoid duplicate edges (otherwise indegree would be over-counted)
                    if (graph.get(ca).add(cb)) {
                        indeg.put(cb, indeg.get(cb) + 1);
                    }
                    break; // only first difference matters
                }
            }
        }

        // 3) Topological sort (Kahn BFS)
        Deque<Character> q = new ArrayDeque<>();
        for (char c : indeg.keySet()) {
            if (indeg.get(c) == 0) q.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char u = q.poll();
            sb.append(u);

            for (char v : graph.get(u)) {
                indeg.put(v, indeg.get(v) - 1);
                if (indeg.get(v) == 0) q.offer(v);
            }
        }

        // 4) If not all letters processed, there is a cycle
        return sb.length() == indeg.size() ? sb.toString() : "";
    }
}