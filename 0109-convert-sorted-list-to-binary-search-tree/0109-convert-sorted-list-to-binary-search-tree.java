/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            ls.add(curr.val);
            curr = curr.next;
        }

        return solve(ls,0,ls.size()-1);
    }
    public TreeNode solve(List<Integer> ls,int l,int r){
        if(l>r)
        return null;

        int mid = l+(r-l)/2;

        TreeNode root = new TreeNode(ls.get(mid));

        root.left = solve(ls,l,mid-1);
        root.right = solve(ls,mid+1,r);
        return root;
    }
}