class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int ans = 0;
        for(int r = 0; r < n; r++){
            char c = s.charAt(r);
            maxFreq = Math.max(++freq[c-'A'], maxFreq);
            while(r - l + 1 - maxFreq > k){
                char leftChar = s.charAt(l);
                freq[leftChar - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
