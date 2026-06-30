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
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = deque.poll();
                if(cur.left != null) deque.offer(cur.left);
                if(cur.right != null) deque.offer(cur.right);
                if(i == size - 1) ans.add(cur.val);
            }
        }
        return ans;
    }
}
