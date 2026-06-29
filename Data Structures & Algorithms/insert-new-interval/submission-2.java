class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1) 先加入所有在 newInterval 左侧、且不相交的区间
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i++]);
        }

        // 2) 合并所有与 newInterval 相交的区间
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval); // 合并结果加入

        // 3) 最后把右侧剩余区间全加入
        while (i < n) ans.add(intervals[i++]);

        return ans.toArray(new int[ans.size()][]);
    }
}
