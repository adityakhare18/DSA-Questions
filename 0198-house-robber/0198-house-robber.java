class Solution {
    public int rob(int[] arr) {
        int idx = arr.length-1;
        int[] dp = new int[idx+1];
        Arrays.fill(dp,-1);
        return solve(arr,idx,dp);
    }
    public int solve(int[] arr,int idx,int[] dp){
        if(idx == 0)
        return arr[idx];
        if(idx < 0)
        return 0;
        
        if(dp[idx] != -1)
        return dp[idx];
        
        int pick = arr[idx] + solve(arr,idx-2,dp);
        int notPick = 0 + solve(arr,idx-1,dp);
        
        
        return dp[idx] = Math.max(pick,notPick);
    }
}