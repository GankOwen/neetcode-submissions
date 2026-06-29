class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
        for (int x : nums) {
            if (pq.size() < k) {
                pq.offer(x);
            } else if (x > pq.peek()) { // 只在更大时替换
                pq.poll();
                pq.offer(x);
            }
        }
        return pq.peek(); 
    }
}
