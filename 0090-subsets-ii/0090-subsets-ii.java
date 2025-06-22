class Solution {
    public void solve(int[] arr, int idx, List<List<Integer>> ans, List<Integer> ls) {

        if (idx >= arr.length) {
            ans.add(new ArrayList<>(ls)); 
            return;
        }

        ls.add(arr[idx]); 
        solve(arr, idx + 1, ans, ls);
        ls.remove(ls.size() - 1); 
        while(idx+1 < arr.length && arr[idx+1] == arr[idx]) idx++;

        solve(arr, idx + 1, ans, ls);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0,ans,list);
        return ans;
    }
}