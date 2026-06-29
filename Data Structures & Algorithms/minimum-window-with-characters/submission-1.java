class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int[] tFreq = new int[128];
        int requires = 0;
        for(char c : t.toCharArray()){
            if(tFreq[c] == 0) requires++;
            tFreq[c]++;
        }

        int l = 0, form = 0;
        int[] sFreq = new int[128];
        int shortestLength = Integer.MAX_VALUE, shortestIndex = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            if(tFreq[c] > 0){
                sFreq[c]++;
                if(tFreq[c] == sFreq[c]){
                    form++;
                }   
            }

            while(form == requires){
                if(r - l + 1 < shortestLength){
                    shortestLength = r - l + 1;
                    shortestIndex = l;
                }
                char leftChar = s.charAt(l);
                if(sFreq[leftChar] > 0){
                    if(tFreq[leftChar] == sFreq[leftChar]) form--;
                    sFreq[leftChar]--;
                }
                
                l++;
            }
        }
        return shortestLength == Integer.MAX_VALUE ? "" : s.substring(shortestIndex, shortestIndex + shortestLength);
    }
}
