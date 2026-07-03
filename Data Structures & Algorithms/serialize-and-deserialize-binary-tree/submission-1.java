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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join(",", list);
    }

    public void dfsSerialize(TreeNode root, List<String> list){
        if(root == null) {
            list.add("#");
            return;
        }
        list.add(String.valueOf(root.val));
        dfsSerialize(root.left, list);
        dfsSerialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]trees = data.split(",");
        int[] index = new int[]{0};
        return dfsDeserialize(trees, index);
    }

    public TreeNode dfsDeserialize(String[] trees, int[] index){
        String cur = trees[index[0]++];
        if(cur.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = dfsDeserialize(trees, index);
        node.right = dfsDeserialize(trees, index);
        return node;
    }
}
