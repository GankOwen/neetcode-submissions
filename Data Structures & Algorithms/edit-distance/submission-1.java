class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][]dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j <= n; j++){
            dp[0][j] = j;
        }
        //word[0...i-1][0...j-1] -> dp[i][j]
        //insert -> word[0...i-1][0...j-2] -> dp[i][j-1]
        //delete -> word[0...i-2][0...j-1] -> dp[i-1][j]
        //replace -> word[0...i-2][0...j-2] -> dp[i-1][j-1]
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1)!= word2.charAt(j-1)){
                    int insert = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
