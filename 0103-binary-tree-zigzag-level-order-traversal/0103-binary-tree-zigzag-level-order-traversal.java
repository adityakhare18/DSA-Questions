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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
        return ans;

        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.add(root);
        int level = 1;
        while(!dq.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            if(level % 2 != 0){
                int size = dq.size();
                for(int i=0;i<size;i++){
                    TreeNode curr = dq.removeFirst();
                    ls.add(curr.val);

                    if(curr.left != null)
                    dq.addLast(curr.left);
                    if(curr.right != null)
                    dq.addLast(curr.right);
                }
            }
            else{
                int size = dq.size();
                for(int i=0;i<size;i++){
                    TreeNode curr = dq.removeLast();
                    ls.add(curr.val);

                    if(curr.right != null)
                    dq.addFirst(curr.right);
                    if(curr.left != null)
                    dq.addFirst(curr.left);
                }
            }
            level++;
            ans.add(ls);
        }
        return ans;
    }
}