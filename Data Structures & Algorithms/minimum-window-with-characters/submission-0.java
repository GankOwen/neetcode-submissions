class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()|| t.length() == 0) return "";
        int[] tRecords = new int[128];
        int requires = 0;
        for(char c : t.toCharArray()){
            if(tRecords[c] == 0) requires++;
            tRecords[c]++;
        }

        int formed = 0;
        int[] sRecords = new int[128];

        int l = 0, bestIndex = 0, bestLength = Integer.MAX_VALUE;
        for(int r = 0; r < s.length(); r++){
            char cur = s.charAt(r);
            if(tRecords[cur] > 0){
                sRecords[cur]++;
                if(tRecords[cur] == sRecords[cur])formed++;
            }

            while(formed == requires){
                if(r - l + 1 < bestLength){
                    bestIndex = l;
                    bestLength = r - l + 1;
                }
                char leftChar = s.charAt(l);
                if(sRecords[leftChar] > 0){
                    if(tRecords[leftChar] == sRecords[leftChar])formed--;
                    sRecords[leftChar]--;
                }
                l++;
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" :s.substring(bestIndex, bestIndex + bestLength);
    }
}
