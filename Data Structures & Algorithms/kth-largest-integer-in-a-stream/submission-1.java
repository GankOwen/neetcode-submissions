class KthLargest {
    private int size;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        minHeap = new PriorityQueue<>();
        for(int i : nums){
            add(i);
        }
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if(this.minHeap.size() > this.size){
            this.minHeap.poll();
        }
        return minHeap.peek();
    }
}
