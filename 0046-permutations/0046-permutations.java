class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans,0,arr);
        return ans;
    }
    public void solve(List<List<Integer>> ans,int idx,int[] arr){
        if(idx == arr.length){
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ls.add(arr[i]);
            }
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=idx;i<arr.length;i++){
            swap(i,idx,arr);
            solve(ans,idx+1,arr);
            swap(i,idx,arr);
        }
    }
    public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}