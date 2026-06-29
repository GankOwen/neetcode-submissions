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
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while(true){
            int i = 0;
            while(fast != null && i < k){
                fast = fast.next;
                i++;
            }
            if(fast == null) break;
            ListNode nextGroup = fast.next;
            ListNode groupHead = slow.next;

            fast.next = null;
            ListNode newHead = reverse(groupHead);

            slow.next = newHead;
            groupHead.next = nextGroup;
            slow = groupHead;
            fast = slow;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode cur = node;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }
}
