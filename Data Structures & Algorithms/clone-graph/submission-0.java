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
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node cur, Map<Node, Node> map) {
        if(map.containsKey(cur)){
            return map.get(cur);
        }
        Node copy = new Node(cur.val);
        map.put(cur, copy);
        for(Node nei : cur.neighbors){
            copy.neighbors.add(dfs(nei, map));
        }

        return copy;
    }
}