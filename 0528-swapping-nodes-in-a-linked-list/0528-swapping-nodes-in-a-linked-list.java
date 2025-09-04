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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null)
        return head;

        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        ListNode beg = head;
        ListNode end = head;
        curr = head;
        for(int i=0;i<k-1;i++){
            beg = beg.next;
        }
        System.out.println(beg.val);

        for(int i=0;i<size - k;i++){
            end = end.next;
        }
        System.out.println(end.val);

        int temp = beg.val;
        beg.val = end.val;
        end.val = temp;

        return head;
    }
}