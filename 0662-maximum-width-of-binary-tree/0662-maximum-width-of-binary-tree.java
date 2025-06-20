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
    class Pair{
        TreeNode n;
        int idx;
        Pair(TreeNode n,int idx){
            this.n = n;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
        return 0;

        Deque<Pair> dq = new ArrayDeque<>();
        int maxWidth = Integer.MIN_VALUE;
        dq.add(new Pair(root,0));
        while(dq.size()>0){
            int st = dq.peekFirst().idx;
            int end = dq.peekLast().idx;
            maxWidth = Math.max(maxWidth, end - st + 1);
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                Pair curr = dq.remove();
                int currIdx = curr.idx - st;  

                if (curr.n.left != null)
                    dq.add(new Pair(curr.n.left, 2 * currIdx + 1));  
                if (curr.n.right != null)
                    dq.add(new Pair(curr.n.right, 2 * currIdx + 2));
            }
        }
        return maxWidth;
    }
}