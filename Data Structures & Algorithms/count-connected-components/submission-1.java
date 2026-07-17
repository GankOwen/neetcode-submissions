class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean [n];
        int ans = 0;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                ans++;
                dfs(i, -1, graph, visited);
            }
        }
        return ans;
    }

    private void dfs(int u, int parent, List<List<Integer>> graph, boolean[] visited){
        visited[u] = true;
        for(int neighbor : graph.get(u)){
            if(neighbor == parent || visited[neighbor]) continue;
            dfs(neighbor, u, graph, visited);
        }
    }
}
