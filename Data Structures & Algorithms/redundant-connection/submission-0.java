class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            g.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0], v = e[1];
            if(checkCycle(g, u, v, n)) return e;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        return new int[0];
    }

    private boolean checkCycle(List<List<Integer>> g, int s, int t, int n){
        boolean[] vis= new boolean[n+1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(s);
        vis[s] = true;
        while(!dq.isEmpty()){
            int x = dq.poll();
            if(x == t) return true;
            for(int y : g.get(x)){
                if(!vis[y]){
                    vis[y] = true;
                    dq.offer(y);
                }
            }
        }
        return false;
    }
}
