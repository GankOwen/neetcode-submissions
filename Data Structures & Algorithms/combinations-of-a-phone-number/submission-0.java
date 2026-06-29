class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;

        String[] mapping = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
        };
        backtrack(ans, new StringBuilder(), digits, 0, mapping);
        return ans;
    }

    private void backtrack(List<String> res, StringBuilder path, String digits, int index, String[] mapping) {
            if(index == digits.length()){
                res.add(path.toString());
                return;
            }
            String letters = mapping[digits.charAt(index) - '0']; 
            for(int i = 0; i < letters.length(); i++){
                path.append(letters.charAt(i));
                backtrack(res, path, digits, index+1, mapping);
                path.deleteCharAt(path.length()-1);
            }
            return;
        }
}
