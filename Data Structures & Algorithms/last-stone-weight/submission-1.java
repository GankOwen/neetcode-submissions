class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i : stones){
            maxHeap.offer(i);
        }
        while(maxHeap.size()!= 1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            maxHeap.offer(a-b);
        }
        return maxHeap.poll();
    }
}
