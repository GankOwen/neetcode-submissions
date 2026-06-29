class Solution {
     public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // 剪枝
        
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        if (hasCycle(0, -1, g, visited)) return false; // 有环
        
        // 确保连通：所有点都访问过
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private boolean hasCycle(int node, int parent, List<List<Integer>> g, boolean[] visited) {
        visited[node] = true;
        for (int nei : g.get(node)) {
            if (nei == parent) continue; // 忽略回到父节点的边
            if (visited[nei] || hasCycle(nei, node, g, visited))
                return true;
        }
        return false;
    }
}
