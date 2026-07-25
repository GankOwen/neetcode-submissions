class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
            int odd = expend(i, i, s);
            int even = expend(i, i+1, s);
            int len = Math.max(odd, even);
            if(len > end - start + 1){
                start = i - (len-1) / 2;
                end = i + len /2;
            }
        }
        return s.substring(start, end+1);
    }

    public int expend(int l, int r, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
