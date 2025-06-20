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
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode tar = markParent(map,root,start);
        return burnTree(tar,map);
    }
    public TreeNode markParent(HashMap<TreeNode, TreeNode> map,TreeNode root,int st){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root,null);
        TreeNode tar = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                if(curr.val == st)
                tar = curr;
                if(curr.left != null){
                    q.add(curr.left);
                    map.put(curr.left,curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    map.put(curr.right,curr);
                }
            }
        }
        return tar;
    }
    public int burnTree(TreeNode root,HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new  LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        q.add(root);
        vis.add(root);

        int ans = 0;


        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
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
                if(map.get(curr) !=null && !vis.contains(map.get(curr))){
                    q.add(map.get(curr));
                    vis.add(map.get(curr));
                    flag = true;
                }
            }
            if(flag)
            ans++;
        }
        return ans;
    }
}