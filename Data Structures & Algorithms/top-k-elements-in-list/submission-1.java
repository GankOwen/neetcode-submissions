class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> records = new HashMap<>();
        for(int i : nums){
            records.put(i, records.getOrDefault(i, 0)+1);
        }
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];
        for(Map.Entry<Integer, Integer> record : records.entrySet()){
            int index = record.getValue();
            if(bucket[index] == null){
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(record.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length-1; i >=0 && res.size() < k; i--){
            if(bucket[i]!=null) res.addAll(bucket[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
