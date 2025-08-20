class Solution {
    public int rob(int[] arr) {
        if(arr.length == 1)
        return arr[0];
        int[] ignoreFirst = Arrays.copyOfRange(arr,1,arr.length);
        int[] ignoreLast = Arrays.copyOfRange(arr,0,arr.length-1);
        int[] dp1 = new int[arr.length];
        Arrays.fill(dp1,-1);

        int[] dp2 = new int[arr.length];
        Arrays.fill(dp2,-1);
        return Math.max(solve(ignoreFirst,0,dp1),solve(ignoreLast,0,dp2));
    }
    public int solve(int[] arr,int idx,int[] dp){
        if(idx >= arr.length)
        return 0;

        if(dp[idx] != -1)
        return dp[idx];

        int pick = arr[idx] + solve(arr,idx+2,dp);
        int notPick = solve(arr,idx+1,dp);

        return dp[idx] = Math.max(pick,notPick);
    }
}