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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> records = new ArrayList<>();
        DFS(root, records, 0);
        return records;
    }

    private void DFS (TreeNode root, List<Integer> records, Integer level){
        if(root == null) return;
        if(level == records.size()){
            records.add(root.val);
        }
        DFS(root.right, records, level+1);
        DFS(root.left, records, level+1);
    }
}
