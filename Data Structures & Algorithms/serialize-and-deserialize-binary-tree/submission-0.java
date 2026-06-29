/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private static final String SEP = ",";
    private static final String NIL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePre(root,sb);
        return sb.toString();
    }

    private void serializePre(TreeNode node, StringBuilder sb) {
        if(node == null){
            sb.append(NIL).append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        serializePre(node.left, sb);
        serializePre(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new ArrayDeque<>();
        for(String s : data.split(SEP)){
            if(!s.isEmpty()){
                deque.offer(s);
            } 
        }
        return build(deque);
    }

    private TreeNode build(Deque<String> q) {
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals(NIL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = build(q);
        node.right = build(q);
        return node;
    }
}
