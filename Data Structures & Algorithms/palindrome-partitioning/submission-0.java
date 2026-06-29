class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<String>(), ans);
        return ans;
    }

    private void dfs(String s, int start, List<String> path, List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end < s.length(); end++){
            String cur = s.substring(start, end+1);
            if(checkPalindrome(cur)){
                path.add(cur);
                dfs(s, end+1, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean checkPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
