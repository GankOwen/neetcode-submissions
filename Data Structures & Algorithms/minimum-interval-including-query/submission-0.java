class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[0], b[0]));

        int n = queries.length;

        int[][] sortedQueries = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        // [length, right]
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

        int[] ans = new int[n];

        int intervalIdx = 0;

        for (int i = 0; i < n; i++) {

            int[] query = sortedQueries[i];

            int q = query[0];
            int origIndex = query[1];

            // 加入所有 left <= q 的 interval
            while (intervalIdx < intervals.length &&
                   intervals[intervalIdx][0] <= q) {

                int l = intervals[intervalIdx][0];
                int r = intervals[intervalIdx][1];

                int len = r - l + 1;

                minHeap.offer(new int[]{len, r});

                intervalIdx++;
            }

            // 删除无法包含 q 的 interval
            while (!minHeap.isEmpty() &&
                   minHeap.peek()[1] < q) {

                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                ans[origIndex] = -1;
            } else {
                ans[origIndex] = minHeap.peek()[0];
            }
        }

        return ans;
    }
}