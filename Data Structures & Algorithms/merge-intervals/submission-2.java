class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int cur[] = intervals[0];
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int[] next = intervals[i];
            if(next[0] <= cur[1]){
                cur[1] = Math.max(next[1], cur[1]);
            }else{
                ans.add(cur);
                cur = next;
            }
        }
        ans.add(cur);
        return ans.toArray(new int[ans.size()][]);
    }
}
