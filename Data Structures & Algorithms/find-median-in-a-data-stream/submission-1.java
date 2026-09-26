class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() > 0){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int totalSize = minHeap.size() + maxHeap.size();
        if(totalSize % 2 != 0){
            return (double) maxHeap.peek();
        }else{
            return ((double) minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
