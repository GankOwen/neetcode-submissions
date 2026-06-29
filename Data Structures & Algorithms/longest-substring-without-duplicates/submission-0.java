class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastShow = new int[256];
        Arrays.fill(lastShow, -1);
        int n = s.length();
        int left = 0;
        int ans = 0;
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            if(lastShow[c] >= left){
                left = lastShow[c] + 1;
            }
            lastShow[c] = right;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
