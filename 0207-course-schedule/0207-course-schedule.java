class Solution {
    public boolean canFinish(int V, int[][] arr) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        int n = arr.length;
        for(int i=0;i<n;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
        }

        int[] indeg = new int[V];
        for(int i=0;i<V;i++){
            for(int nbr : adj.get(i)){
                indeg[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i] == 0)
            q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int nbr:adj.get(node)){
                indeg[nbr]--;
                if(indeg[nbr] == 0)
                q.add(nbr);
            }
        }
        return ans.size() == V ? true : false;
    }
}