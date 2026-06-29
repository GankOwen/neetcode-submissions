class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0, ans = 0, maxFreq = 0;
        for(int right = 0; right < n; right++){
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);
            while(right - left + 1 - maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            } 
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
