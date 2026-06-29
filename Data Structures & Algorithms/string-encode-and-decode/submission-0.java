class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String cur : strs){
            sb.append(cur.length()).append('#').append(cur);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int n = str.length();
        int i = 0;
        while(i < n){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int strLength = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1, j+1+strLength);
            ans.add(word);
            i = j+1+strLength;
        }
        return ans;
    }
}
