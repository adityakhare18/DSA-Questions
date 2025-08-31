class Solution {
    public List<Integer> eventualSafeNodes(int[][] arr) {
        int V = arr.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }


        int indegree[] = new int[V];

        for(int i = 0; i < V; i++)
        {
            for(int p: arr[i])
            {
                adj.get(p).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0)
            q.add(i);
        }

        List<Integer> ls = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ls.add(node);

            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0)
                q.add(nbr);
            }
        }
        Collections.sort(ls);
        return ls;
        
    }
}