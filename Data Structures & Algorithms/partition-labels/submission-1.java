class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastSeen = new int[26];
        for(int i = 0; i < s.length(); i++){
            lastSeen[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
        
            end = Math.max(lastSeen[c - 'a'], end);
            if(i == end){
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
