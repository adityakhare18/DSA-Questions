class Solution {
    public int rob(int[] arr) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        return solve(arr,0,dp);
    }
    public int solve(int[] arr,int idx,int[] dp){
        if(idx >= arr.length){
            return 0;
        }

        if(dp[idx] != -1)
        return dp[idx];


        int pick = arr[idx] + solve(arr,idx+2,dp);
        int notPick = solve(arr,idx+1,dp);

        return dp[idx] = Math.max(pick,notPick);
    }
}