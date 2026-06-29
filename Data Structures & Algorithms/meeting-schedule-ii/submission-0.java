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
        int n = intervals.size();
        int[] starts = new int[n], ends = new int[n];
        for(int i = 0; i < n; i++){
            Interval cur = intervals.get(i);
            starts[i] = cur.start;
            ends[i] = cur.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0, rooms = 0, maxRooms = 0;
        while(i < n){
            if(starts[i] < ends[j]){
                rooms++;
                maxRooms = Math.max(rooms, maxRooms);
                i++;
            }else{
                rooms--;
                j++;
            }
        }
        return maxRooms;
    }
}
