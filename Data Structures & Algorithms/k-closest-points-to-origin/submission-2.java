class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> Long.compare(distance(b), distance(a)));
        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }

    private long distance(int[] a){
        int x = a[0];
        int y = a[1];
        return 1L * x * x + 1L * y * y;
    }
}
