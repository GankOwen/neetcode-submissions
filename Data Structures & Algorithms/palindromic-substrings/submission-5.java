class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for(int len = 1; len <= n ; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len <= 2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                    
                }
                if(dp[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
