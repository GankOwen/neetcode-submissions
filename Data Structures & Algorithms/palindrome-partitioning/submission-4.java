class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        // dp[i][j] 表示 s[i...j] 是否是回文
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(s, 0, path, ans, dp);

        return ans;
    }

    private void dfs(
        String s,
        int start,
        List<String> path,
        List<List<String>> ans,
        boolean[][] dp
    ) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));

                dfs(s, end + 1, path, ans, dp);

                path.remove(path.size() - 1);
            }
        }
    }
}
