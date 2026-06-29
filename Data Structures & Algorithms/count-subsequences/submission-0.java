class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        long[][]dp = new long[n+1][m+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            char s_c = s.charAt(i-1);
            for(int j = 1; j <= m; j++){
                char t_c = t.charAt(j-1);
                if(s_c == t_c){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return (int)dp[n][m];
    }
}
