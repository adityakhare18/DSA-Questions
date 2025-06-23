class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        solve(ans,0,arr,ls);
        return ans;
    }
    public void solve(List<List<Integer>> ans,int idx,int[] arr,List<Integer> ls){
        if(idx == arr.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        //pick
        ls.add(arr[idx]);
        solve(ans,idx+1,arr,ls);
        ls.remove(ls.size()-1);

        //not pick
        solve(ans,idx+1,arr,ls);
        

    }
}