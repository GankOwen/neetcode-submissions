class Solution {
    Map<String, PriorityQueue<String>> g = new HashMap<>();
    Deque<String> route = new ArrayDeque<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets)
            g.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).offer(t.get(1));
        dfs("JFK");
        return new ArrayList<>(route); // route 已经是正序
    }

    private void dfs(String u) {
        PriorityQueue<String> pq = g.get(u);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        route.addFirst(u); // 回填
    }
}
