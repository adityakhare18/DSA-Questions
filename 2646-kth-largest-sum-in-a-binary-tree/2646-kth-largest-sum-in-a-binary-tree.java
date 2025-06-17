class Solution {
    static class Pair implements Comparable<Pair> {
        long sum;
        public Pair(long sum) {
            this.sum = sum;
        }
        @Override
        public int compareTo(Pair p2) {
            return Long.compare(this.sum, p2.sum);
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                sum += curr.val;
                if(curr.left != null)
                q.add(curr.left);
                if(curr.right != null)
                q.add(curr.right);
            }
            pq.add(new Pair(sum));
            if(pq.size() > k)
            pq.remove();
        }

        return pq.size() == k ? pq.peek().sum : -1;
    }
}