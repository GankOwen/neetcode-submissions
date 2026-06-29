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
        dfs(root, 0, records);
        return new ArrayList<>(records.values());
    }

    public void dfs(TreeNode root, int level, Map<Integer, List<Integer>> records){
        if(root == null) return;
        List<Integer> currentLevel = records.getOrDefault(level, new ArrayList<>());
        currentLevel.add(root.val);
        records.put(level, currentLevel);
        dfs(root.left, level+1, records);
        dfs(root.right, level+1, records);
    }
}
