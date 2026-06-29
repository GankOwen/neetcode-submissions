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
        Node newListTail = new Node(-1);
        while(cur != null){
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            newListTail.next = newNode;
            newListTail = newListTail.next;
            cur = cur.next;
        }

        Node dummy = new Node(-1);
        dummy.next = map.get(head);
        Node copyCur = dummy.next;
        cur = head;
        while(cur != null){
            Node randomNode = (cur.random == null) ? null : map.get(cur.random);
            copyCur.random = randomNode;
            copyCur = copyCur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
