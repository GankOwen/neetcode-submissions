class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int maxLen = 0;

        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        for(int i = 1; i <= n; i++){
            for(int len = 1; len <= maxLen; len++){
                int j = i - len;
                if(j < 0) break;
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
