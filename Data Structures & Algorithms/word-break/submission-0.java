class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int maxLen = 0;
        for(String w : wordDict){
            maxLen = Math.max(maxLen, w.length());
        }

        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            int start = Math.max(0, i - maxLen);
            for(int j = start; j <= i; j++){
                String cur = s.substring(j, i);
                if(dp[j] && set.contains(cur)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
