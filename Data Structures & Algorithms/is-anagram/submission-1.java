class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()) return false;
        int[] recordsOfS = new int[26];
        int[] recordsOfT = new int[26];

        int n = s.length();

        for(int i = 0; i < n; i++){
            recordsOfS[s.charAt(i)-'a']++;
            recordsOfT[t.charAt(i)-'a']++; 
        }
        for(int i = 0; i < 26; i++){
            if(recordsOfS[i] != recordsOfT[i]) return false;
        }
        return true;
    }
}
