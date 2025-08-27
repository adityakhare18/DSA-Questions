class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int cnt = 0;
        boolean[] vis = new boolean[n+1];
        for(int i=0;i<adj.size();i++){
            if(!vis[i]){
                cnt++;
                bfs(adj,i,vis);
            }
        }
        return cnt;
    }
    public void bfs(List<List<Integer>> adj,int curr,boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        vis[curr] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int nbr : adj.get(node)){
                if(!vis[nbr]){
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }
}