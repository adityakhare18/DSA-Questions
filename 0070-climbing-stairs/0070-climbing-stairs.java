class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n,int[] dp){
        if(n == 0  || n == 1)
        return 1; 
        if(dp[n] != -1)
        return dp[n];
        int l = solve(n-1,dp);
        int r = solve(n-2,dp);

        dp[n] = l + r;

        return dp[n];
    }
}