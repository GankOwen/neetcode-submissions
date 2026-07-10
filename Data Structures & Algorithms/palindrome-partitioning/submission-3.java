class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dividingSubstring(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dividingSubstring(String s, int start, List<String> path, List<List<String>> ans){
        if(start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                path.add(s.substring(start, end+1));
                dividingSubstring(s, end+1, path, ans);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome (String s, int l, int r){
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
