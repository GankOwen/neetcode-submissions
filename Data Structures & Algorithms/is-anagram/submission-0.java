class Solution {
    public boolean isAnagram(String s, String t) {
        int[] records = new int[26];
        for(char i : s.toCharArray()){
            records[i-'a']++;
        }
        for(char j : t.toCharArray()){
            records[j-'a']--;
        }
        for(int k = 0; k < records.length; k++){
            if(records[k]!=0) return false;
        }
        return true;
    }
}
