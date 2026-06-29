class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int m = s1.length();
        for(int r = 0; r < s2.length(); r++){
            s2Freq[s2.charAt(r)-'a']++;
            if(r >= m){
                s2Freq[s2.charAt(r-m)-'a']--;
            }
            if(r >= m - 1 && Arrays.equals(s1Freq, s2Freq)) return true;
        }
        return false;
    }
}
