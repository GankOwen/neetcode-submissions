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
            for(int len = 1; len <= maxLen; len++){
                int j =  i - len;
                if(j < 0) break;
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
