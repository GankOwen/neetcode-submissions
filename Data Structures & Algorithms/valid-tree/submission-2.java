class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        deque.offer(0);
        visited[0] = true;
        int count = 1;

        while(!deque.isEmpty()){
            int cur = deque.poll();
            for(int neighbor : graph.get(cur)){
                if(visited[neighbor]) continue;
                visited[neighbor] = true;
                deque.offer(neighbor);
                count++;
            }
        }
        return count == n;
    }
}
