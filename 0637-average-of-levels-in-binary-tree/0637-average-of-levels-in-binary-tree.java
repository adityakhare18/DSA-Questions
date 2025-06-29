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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                sum+=curr.val;
                if(curr.left != null)
                q.add(curr.left);
                if(curr.right != null)
                q.add(curr.right);
            }
            double avg = (double)sum/size;
            ans.add(avg);
        }
        return ans;
    }
}