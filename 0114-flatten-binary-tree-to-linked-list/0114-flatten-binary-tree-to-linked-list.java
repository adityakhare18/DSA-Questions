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
    public void flatten(TreeNode root) {
    ArrayList<TreeNode> ls = new ArrayList<>();
    solve(root, ls);

    for (int i = 0; i < ls.size() - 1; i++) {
        TreeNode curr = ls.get(i);
        TreeNode next = ls.get(i + 1);
        curr.left = null;
        curr.right = next;
    }

    if (!ls.isEmpty()) {
        TreeNode last = ls.get(ls.size() - 1);
        last.left = null;
        last.right = null;
    }
}

public void solve(TreeNode root, ArrayList<TreeNode> ls) {
    if (root == null)
        return;

    ls.add(root);
    solve(root.left, ls);
    solve(root.right, ls);
}    
}