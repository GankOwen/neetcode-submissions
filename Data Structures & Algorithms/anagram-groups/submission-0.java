class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> records = new  HashMap<>();
        for(String cur : strs){
            char[] curStr = cur.toCharArray();
            Arrays.sort(curStr);
            String key = String.valueOf(curStr);
            records.computeIfAbsent(key, k -> new ArrayList<>()).add(cur);
        }
        return new ArrayList<>(records.values());
    }
}
