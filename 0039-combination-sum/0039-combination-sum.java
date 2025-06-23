class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        solve(ans,ls,0,target,arr);
        return ans;
    }
    public void solve(List<List<Integer>> ans,List<Integer> ls,int idx,int target,int[] arr){
        if(idx == arr.length){
            if(target == 0)
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(arr[idx] <= target){
            ls.add(arr[idx]);
            solve(ans,ls,idx,target-arr[idx],arr);
            ls.remove(ls.size()-1);
        }
        solve(ans,ls, idx+1, target,arr);
    }
}