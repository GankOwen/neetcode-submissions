class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j = 2; j <= n; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char patternChar = p.charAt(j-1);
                char stringChar = s.charAt(i-1);
                if(patternChar != '*'){
                    if(patternChar == '.'|| patternChar == stringChar){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }else{
                    // 情况一：* 匹配 0 个前面的字符
                    dp[i][j] = dp[i][j-2];
                    // 情况二：* 匹配 1 个或多个前面的字符
                    char prevPatternChar = p.charAt(j-2);
                    if(prevPatternChar == '.' || prevPatternChar == stringChar){
                        dp[i][j] |= dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
