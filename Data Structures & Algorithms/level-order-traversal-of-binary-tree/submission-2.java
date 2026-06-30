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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> records = new HashMap<>();
        DFS(root, records, 0);
        return new ArrayList<>(records.values());
    }

    private void DFS(TreeNode root, Map<Integer, List<Integer>> records, int level){
        if(root == null) return;
        records.computeIfAbsent(level, k -> new ArrayList<>()).add(root.val);
        DFS(root.left, records, level+1);
        DFS(root.right, records, level+1);
    }
}
