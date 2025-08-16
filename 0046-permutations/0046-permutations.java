class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        boolean[] vis = new boolean[arr.length];
        solve(arr,ans,ls,vis);
        return ans;
    }
    public void solve(int[] arr,List<List<Integer>> ans,List<Integer> ls,boolean[] vis){
        if(ls.size() == arr.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                ls.add(arr[i]);
                vis[i] = true;
                solve(arr,ans,ls,vis);
                vis[i] = false;
                ls.remove(ls.size()-1);
            }
        }
    }
}