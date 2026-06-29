class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            String sortedKey = new String(cur);
            if(!map.containsKey(sortedKey)){
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
