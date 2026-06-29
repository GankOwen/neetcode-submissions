class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> records = new HashMap<>();
        for(int i : nums){
            records.put(i, records.getOrDefault(i, 0)+1);
        }

        PriorityQueue <Map.Entry<Integer, Integer>> heap = 
            new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> record : records.entrySet()){
            heap.offer(record);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }
}
