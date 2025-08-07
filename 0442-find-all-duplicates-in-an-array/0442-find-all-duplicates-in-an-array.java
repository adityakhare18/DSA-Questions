class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            int idx = Math.abs(arr[i]);
            if(arr[idx-1] < 0)
            ans.add(idx);

            arr[idx-1] *= -1;
        }
        return ans;
    }
}