class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i] % 2 == 0)
            arr[i] = 0;
            else
            arr[i] = 1;
        }
        return solve(arr,k) - solve(arr,k-1);
    }
    public int solve(int[] arr,int k){
        int l=0,r=0,sum=0,cnt=0;
        while(r < arr.length){
            sum += arr[r++];
            while(l <= r && sum > k){
                sum -= arr[l++];
            }
            if(sum <= k){
                cnt += (r-l+1);
            }
        }
        return cnt;
    }
}