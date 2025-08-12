class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                arr[i] = 0;
            }
            else
            arr[i] = 1;
        }

        return solve(arr,k) - solve(arr,k-1);
    }
    public int solve(int[] arr,int k){
        int l = 0,r = 0,n = arr.length;
        int sum = 0,ans = 0;

        while(r < n){
            sum += arr[r];
            while(sum > k){
                sum -= arr[l++];
            }
            if(sum <= k){
                ans += (r-l+1);
            }
            r++;
        }
        return ans;
    }
}