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
    private int kLeft, ans;
    public int kthSmallest(TreeNode root, int k) {
        kLeft = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode node) {
        if(node == null || kLeft == 0) return;
        dfs(node.left);
        if(--kLeft == 0){
            ans = node.val;
            return;
        }
        dfs(node.right);
    }
}
