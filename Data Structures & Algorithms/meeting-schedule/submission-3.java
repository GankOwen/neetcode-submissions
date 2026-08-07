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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()==0)return true;
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        Interval cur = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval next = intervals.get(i);
            if(cur.end > next.start) return false;
            cur = next;
        }
        return true;
    }
}
