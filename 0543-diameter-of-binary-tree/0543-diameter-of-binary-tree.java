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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = {0};
        height(root,ans);
        return ans[0];
    }
    public int height(TreeNode root,int[] ans){
        if(root == null){
            return 0;
        }

        int l = height(root.left,ans);
        int r = height(root.right,ans);

        ans[0] = Math.max(ans[0],(l+r));

        return 1 + Math.max(l,r);
    }
}