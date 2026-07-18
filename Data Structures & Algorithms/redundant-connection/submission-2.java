class Solution {
    private int[] parents;
    private int[] ranks;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        this.parents = new int[n+1];
        this.ranks = new int[n+1];
        for(int i = 1; i <= n; i++){
            this.parents[i] = i;
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            if(!union(u,v)){
                return e;
            }
        }
        return new int[0];
    }

    private int find(int x){
        if(parents[x] != x){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    private boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY){
            return false;
        }

        if(this.ranks[rootX] < this.ranks[rootY]){
            this.parents[rootX] = rootY;
        }else if(this.ranks[rootX] > this.ranks[rootY]){
            this.parents[rootY]  = rootX;
        }else{
            this.parents[rootY] = rootX;
            ranks[rootX]++;
        }
        return true;
    }
}
