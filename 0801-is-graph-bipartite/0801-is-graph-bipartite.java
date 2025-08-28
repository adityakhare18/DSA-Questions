class Solution {
    public boolean isBipartite(int[][] arr) {
        int n = arr.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        // check all components
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(arr, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int[][] arr, int[] color, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; 

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nbr : arr[node]) {
                if (color[nbr] == -1) {
                    // Assign opposite color
                    color[nbr] = 1 - color[node];
                    q.add(nbr);
                } else if (color[nbr] == color[node]) {
                    // Conflict: same color on both ends
                    return false;
                }
            }
        }
        return true;
    }
}
