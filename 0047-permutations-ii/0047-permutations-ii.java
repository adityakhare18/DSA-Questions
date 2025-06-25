class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[arr.length];
        solve(ans,ls,vis,arr);
        return ans;
    } 

    public void solve(List<List<Integer>> ans,List<Integer> ls,boolean[] vis,int[] arr){
        if(ls.size() == arr.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                //Skip duplicates (only if previous identical number wasn't used)
                if (i > 0 && arr[i] == arr[i - 1] && !vis[i - 1]) continue;
                ls.add(arr[i]);
                vis[i] = true;
                solve(ans,ls,vis,arr);
                vis[i] = false;
                ls.remove(ls.size()-1);
            }
        }
    }
}