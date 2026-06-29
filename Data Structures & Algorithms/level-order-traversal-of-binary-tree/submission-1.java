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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while(!deque.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = deque.size();
            for(int i = 0; i < n; i++){
                TreeNode cur = deque.poll();
                level.add(cur.val);
                if(cur.left != null) deque.offer(cur.left);
                if(cur.right != null) deque.offer(cur.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
