/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> seen = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();

        seen.put(node, new Node(node.val));
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei : cur.neighbors) {
                if (!seen.containsKey(nei)) {
                    seen.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                // 建边：给克隆节点补上邻居的克隆
                seen.get(cur).neighbors.add(seen.get(nei));
            }
        }
        return seen.get(node);
    }
}