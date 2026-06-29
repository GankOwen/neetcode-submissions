class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> t : tickets){
            graph.computeIfAbsent(t.get(0), k -> new PriorityQueue<String> ()).offer(t.get(1));
        }

        Deque<String> stack = new ArrayDeque();
        Deque<String> route = new ArrayDeque();
        stack.push("JFK");

        while(!stack.isEmpty()){
            String cur = stack.peek();
            PriorityQueue<String> pq = graph.get(cur);
            if(pq != null && !pq.isEmpty()){
                stack.push(pq.poll());
            }else{
                route.addFirst(stack.pop());
            }
        }
        return new ArrayList<>(route);
    }
}
