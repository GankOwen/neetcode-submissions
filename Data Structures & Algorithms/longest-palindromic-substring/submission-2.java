class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        int maxLen = 0;
        for(int len = 1; len <= n; len++){
            for(int i = 0; i+len-1 < n; i++){
                int j  = i + len - 1;
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(len <= 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && len > maxLen){
                    maxLen = len;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end+1);
    }
}
