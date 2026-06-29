class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        int[] counts = new int[26];
        int maxCount = 0;
        for(char c : tasks){
            int cur = c - 'A';
            counts[cur]++;
            maxCount = Math.max(maxCount, counts[cur]);
        }
        int numMax = 0;
        for(int x : counts){
            if(x==maxCount) numMax++;
        }
        int frameLen = (maxCount - 1) * (n+1) + numMax;
        return Math.max(frameLen, tasks.length);
    }
}
