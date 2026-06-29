class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(dist(b), dist(a))
        );
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            } 
        }
        int[][] ans = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) ans[i++] = pq.poll();
        return ans;
    }

    private long dist(int[] p) { // 用 long 防止溢出
        return 1L * p[0] * p[0] + 1L * p[1] * p[1];
    }
}
