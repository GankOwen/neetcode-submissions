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
    public boolean isBalanced(TreeNode root) {
        int ans = dfs(root);
        return ans == -1? false : true;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftDepth = dfs(root.left);
        if(leftDepth == -1) return -1;
        int rightDepth = dfs(root.right);
        if(rightDepth == -1) return -1;

        int diff = Math.abs(leftDepth - rightDepth);
        return diff > 1 ? -1 : Math.max(leftDepth, rightDepth)+1;
    }
}
