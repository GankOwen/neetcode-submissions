class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    Deque<String> queue = new ArrayDeque<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String departure = ticket.get(0), arrival = ticket.get(1);
            graph.computeIfAbsent(departure, k -> new PriorityQueue<String>()).offer(arrival);
        }
        dfs("JFK");
        return new ArrayList<>(queue);
    }

    private void dfs(String departure){
        PriorityQueue<String> arrivals = graph.get(departure);
        while(arrivals != null && !arrivals.isEmpty()){
            dfs(arrivals.poll());
        }
        queue.addFirst(departure);
    }
}
