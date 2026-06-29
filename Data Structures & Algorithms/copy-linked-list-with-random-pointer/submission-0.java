/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node dummy = new Node(0), tail = dummy;

        while(cur != null){
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            tail.next = copy;
            tail = tail.next;
            cur = cur.next;
        }

        cur = head;
        Node copyCur = dummy.next;
        while(cur != null){
            copyCur.random = cur.random == null ? null : map.get(cur.random);
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return dummy.next;
    }
}
