class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += expend(i, i, s);
            ans += expend(i, i+1, s);
        }
        return ans;
    }

    public int expend(int l, int r, String s){
        int count = 0;

        while (l >= 0
                && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }

        return count;
    }
}
