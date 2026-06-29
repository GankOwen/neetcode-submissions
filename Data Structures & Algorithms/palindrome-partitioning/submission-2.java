class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        if (n == 0) return ans;
        boolean[][] isPal = precomputeByDP(s);
        dfs(s, 0, new ArrayList<String>(), ans, isPal);
        return ans;
    }

    private void dfs(String s, int start, List<String> path, List<List<String>> ans, boolean[][] isPal){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end < s.length(); end++){
            String cur = s.substring(start, end+1);
            if(isPal[start][end]){
                path.add(cur);
                dfs(s, end+1, path, ans, isPal);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean[][] precomputeByDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int len = 1; len <= n; len++){
            for(int l = 0; l + len - 1 < n; l++){
                int r = l + len -1;
                if(s.charAt(l) == s.charAt(r)){
                    dp[l][r] = (len <= 3) || dp[l + 1][r - 1];
                    //长度 1：如 "a"，天然回文；
                    //长度 2：如 "aa"，只要两字符相等就是回文；
                    //长度 3：如 "aba"，只要首尾相等，中间一个字符随便。
                }
            }
        }
        return dp;
    }
}
