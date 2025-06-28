class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int n = cost.length;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // dp[0] = cost[0];dp[1] = cost[1];
        // int ans = Math.min(solve(n-1,cost,),solve(cost));
        // return ans;

        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }


    //below is memoization code

    // public int solve(int n,int[] cost,int[] dp){
    //     if(n == 0)
    //     return cost[0];
    //     if(n == 1)
    //     return cost[1];
    //     if(dp[n] != -1)
    //     return dp[n];
    //     int l = solve(n-1,cost,dp);
    //     int r = solve(n-2,cost,dp);
    //     dp[n] = cost[n] + Math.min(l,r);

    //     return dp[n];
    // }
}