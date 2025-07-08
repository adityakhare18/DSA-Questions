class Solution {
    public int rob(int[] arr) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        return solve(arr,dp,0);
    }
    public int solve(int[] arr,int[] dp,int idx){
        if(idx >= arr.length){
            return 0;
        }

        if(dp[idx] != -1)
        return dp[idx];

        //exclude
        int noTake = solve(arr,dp,idx+1);

        int take = arr[idx] + solve(arr,dp,idx+2);

        return dp[idx] = Math.max(take,noTake);
    }
}