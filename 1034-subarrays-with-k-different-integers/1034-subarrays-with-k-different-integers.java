class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        return solve(arr,k) - solve(arr,k-1);
    }
    public int solve(int[] arr,int k){
        int l=0,r=0,n=arr.length;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size() > k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l]) == 0)
                map.remove(arr[l]);
                l++;
            }
            if(map.size() <= k){
                ans += r-l+1;
            }
            r++;
        }
        return ans;
    }
}