class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexs = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            lastIndexs[c-'a'] =  i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, rightMostIndex = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            rightMostIndex = Math.max(lastIndexs[c-'a'], rightMostIndex);
            if(i==rightMostIndex){
                res.add(rightMostIndex - start + 1);
                start = i+1;
            }
        }
        return res;
    }
}
