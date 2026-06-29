class Solution {
     public int countSubstrings(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n]; // dp[j] 表示“当前 i 行”的 dp[i][j]
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) { // 右→左
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[j - 1])) {
                    dp[j] = true;
                    ans++;
                } else {
                    dp[j] = false;
                }
            }
        }
        return ans;
    }
}
