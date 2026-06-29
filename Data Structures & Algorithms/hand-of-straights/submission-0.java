class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        if(groupSize == 1) return true;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int x : hand){
            freq.put(x, freq.getOrDefault(x, 0)+1);
        }

        while(!freq.isEmpty()){
            int start = freq.firstKey();
            for(int v = start; v < start + groupSize ; v++){
                Integer count = freq.get(v);
                if(count == null) return false;
                if(count == 1) freq.remove(v);
                else freq.put(v, count - 1);
            }
        }
        return true;
    }
}
