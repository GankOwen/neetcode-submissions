class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int write = 0;
        intervals[write] = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            int[] last = intervals[write];
            int[] cur = intervals[i];
            if(cur[0] <= last[1]){
                last[1] = Math.max(last[1], cur[1]);
            }else{
                intervals[++write] = cur;
            }
        }
        return Arrays.copyOfRange(intervals, 0, write+1);
    }
}
