class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>(Arrays.asList(intervals));
        temp.add(newInterval);
        temp.sort((a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] prev = temp.get(0); 
        for(int i = 1; i < temp.size(); i++){
            int[] cur = temp.get(i);
            if(prev[1] >= cur[0]){
                prev[1] = Math.max(prev[1], cur[1]);
            }else{
                ans.add(prev);
                prev = cur;
            }
        }
        ans.add(prev);
        return ans.toArray(new int[ans.size()][]);
    }
}
