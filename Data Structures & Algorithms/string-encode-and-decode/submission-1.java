class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(str.length() == 0) return res;
        int n = str.length();
        int i = 0;
        while(i < n){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int strLen = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1, j+1+strLen);
            res.add(word);
            i = j+1+strLen;
        }
        return res;
    }
}
