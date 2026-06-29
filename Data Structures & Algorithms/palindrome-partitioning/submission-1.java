class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        if (n == 0) return ans;
        boolean[][] isPal = precomputeByCenter(s);
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

    private boolean[][] precomputeByCenter(String s){
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for(int c  = 0; c < n; c++){
            expand(s, c, c, isPal);       // odd
            expand(s, c, c + 1, isPal);   // even
        }
        return isPal;
    }

    private void expand(String s, int l, int r, boolean[][] isPal){
        int n = s.length();
        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
            isPal[l][r] = true;
            l--;
            r++;
        }
    }
}
