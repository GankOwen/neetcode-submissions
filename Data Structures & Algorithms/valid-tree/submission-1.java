class Solution {
     public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] e : edges) {
            int a = find(parent, e[0]);
            int b = find(parent, e[1]);
            if (a == b) return false; // 有环
            parent[a] = b;            // 合并集合
        }
        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
