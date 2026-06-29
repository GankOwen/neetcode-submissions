class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> out = new ArrayList<>();
        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= cur[1]) {                 // 题目规定 [1,2] 与 [2,3] 也算重叠
                cur[1] = Math.max(cur[1], next[1]);  // 合并到 cur
            } else {
                out.add(cur);                         // cur 已确定
                cur = next;
            }
        }
        out.add(cur);
        return out.toArray(new int[out.size()][]);
    }
}
