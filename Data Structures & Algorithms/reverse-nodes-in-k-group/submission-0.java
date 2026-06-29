/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k <=1) return head;
        ListNode dummy = new ListNode(-1, head);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        while(true){
            for(int i = 0; i < k && fast != null; i++){
                fast = fast.next;
            }
            if(fast == null) break;

            ListNode groupStart = slow.next;
            ListNode groupNext = fast.next;

            ListNode prev = groupNext;
            ListNode cur = groupStart;
            while(cur != groupNext){
                ListNode nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }
            slow.next = prev;
            slow = groupStart;
            fast = slow;
        }
        return dummy.next;
    }

}
