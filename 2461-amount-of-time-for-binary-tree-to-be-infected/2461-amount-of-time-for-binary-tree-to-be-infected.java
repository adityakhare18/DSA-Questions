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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        TreeNode tar = makeParent(root,start,parent);
        return burnTree(root,tar,parent);

    }
    public TreeNode makeParent(TreeNode root,int st,HashMap<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode target = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == st)
                target = curr;
                if(curr.left != null){
                    parent.put(curr.left,curr);
                    q.add(curr.left);
                }
                if(curr.right != null){
                    parent.put(curr.right,curr);
                    q.add(curr.right);
                }
            }
        }
        return target;
    }
    public int burnTree(TreeNode root,TreeNode target,HashMap<TreeNode,TreeNode> parent){
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        vis.add(target);
        q.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && !vis.contains(curr.left)){
                    q.add(curr.left);
                    vis.add(curr.left);
                    flag = true;
                }
                if(curr.right != null && !vis.contains(curr.right)){
                    q.add(curr.right);
                    vis.add(curr.right);
                    flag = true;
                }
                if(parent.get(curr) != null && !vis.contains(parent.get(curr))){
                    q.add(parent.get(curr));
                    vis.add(parent.get(curr));
                    flag = true;
                }
            }
            if(flag)
            ans++;
        }
        return ans;
    }
}