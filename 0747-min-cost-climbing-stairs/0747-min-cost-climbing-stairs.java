class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = Math.min(solve(n-1,cost,dp),solve(n-2,cost,dp));
        return ans;
    }
    public int solve(int n,int[] cost,int[] dp){
        if(n == 0)
        return cost[0];
        if(n == 1)
        return cost[1];
        if(dp[n] != -1)
        return dp[n];
        int l = solve(n-1,cost,dp);
        int r = solve(n-2,cost,dp);
        dp[n] = cost[n] + Math.min(l,r);

        return dp[n];
    }
}