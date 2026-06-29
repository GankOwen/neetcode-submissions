/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 存结束时间
        for (Interval itv : intervals) {
            if (!pq.isEmpty() && pq.peek() <= itv.start) pq.poll(); // 复用
            pq.offer(itv.end);
        }
        return pq.size();
    }
}
