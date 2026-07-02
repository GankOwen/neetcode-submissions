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
    private int preorderIndex;
    private Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int inLeft, int inRight){
        if(inLeft > inRight) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode cur = new TreeNode(rootVal);
        cur.left = helper(preorder, inLeft, inorderMap.get(rootVal) - 1);
        cur.right = helper(preorder, inorderMap.get(rootVal) + 1, inRight);

        return cur;
    } 
}
