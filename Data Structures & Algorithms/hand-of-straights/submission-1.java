class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> records = new TreeMap<>();
        for(int card : hand){
            records.put(card, records.getOrDefault(card, 0)+1);
        }

        while(!records.isEmpty()){
            int start = records.firstKey();
            for(int card = start; card < start + groupSize; card++){
                Integer freq = records.get(card);
                if(freq == null) return false;
                if(freq == 1){
                    records.remove(card);
                }else{
                    records.put(card, freq - 1);
                }
            }
        }
        return true;
    }
}
