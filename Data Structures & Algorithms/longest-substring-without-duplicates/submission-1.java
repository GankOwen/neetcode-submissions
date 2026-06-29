class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, ans = 0;
        int[] lastShow = new int[256];
        Arrays.fill(lastShow, -1);
        for(int r = 0; r < n; r++){
            char c = s.charAt(r);
            if(lastShow[c] >= l){
                l = lastShow[c] + 1;
            }
            ans = Math.max(ans, r - l + 1);
            lastShow[c] = r;
        }
        return ans;
    }
}
