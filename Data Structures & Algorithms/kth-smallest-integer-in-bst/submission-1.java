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
        this.kLeft = k;
        DFS(root);
        return ans;
    }

    private void DFS (TreeNode root){
        if(root == null || this.kLeft == 0) return ;
        DFS(root.left);
        if(--this.kLeft == 0){
            ans = root.val;
            return;
        }
        DFS(root.right);
    }
}
