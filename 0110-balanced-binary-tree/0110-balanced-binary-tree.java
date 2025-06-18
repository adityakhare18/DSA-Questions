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
        boolean[] ans = {true};
        solve(root,ans);
        return ans[0];
    }
    public int solve(TreeNode root,boolean[] ans){
        if(root == null)
        return 0;

        int l = solve(root.left,ans);
        int r = solve(root.right,ans);

        if(Math.abs(l - r) > 1)
        ans[0] = false;

        return 1 + Math.max(l,r);
    }
}