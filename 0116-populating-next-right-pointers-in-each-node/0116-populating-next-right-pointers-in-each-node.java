class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                // If it's not the last node in the level
                if (i < size - 1) {
                    curr.next = q.peek();  // next node in the queue is the next right node
                } else {
                    curr.next = null;  // last node in this level
                }

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return root;
    }
}
